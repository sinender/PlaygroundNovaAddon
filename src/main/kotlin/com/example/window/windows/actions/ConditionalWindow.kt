package com.example.window.windows.actions

import com.al3x.housing2.Action.Actions.ConditionalAction
import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeActionsWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.window.Window
import java.util.LinkedHashMap

class ConditionalWindow : AlternativeActionsWindow("Conditional Action") {
    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". c i . b . s . .",
                    ". . . . . . . . ."
                )
            )
            .addIngredient('c', GuiItems.COPY_TO_CLIPBOARD.createItemBuilder(), 36-9)
            .addIngredient('i', GuiItems.IMPORT_FROM_CLIPBOARD.createItemBuilder(), 37-9)
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 40-9)
            .addIngredient('s', GuiItems.SET_COMMENT.createItemBuilder(), 44-9)

        return lowerGui!!
    }

    override fun getData(): LinkedHashMap<String, Any> {
        (action as? ConditionalAction)?.let {
            return it.data()
        }
        return LinkedHashMap()
    }

    override fun createUpperGui(): Gui.Builder<*, *> {
        var data = getData()

        var conditions = data["conditions"] as List<*>?
        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". c c c c . n & .",
                    ". . . . . . . . .",
                    ". . i i i i i . .",
                    ". . e e e e e . ."
                )
            )
            .addIngredient('c', GuiItems.CONDITIONS.createItemBuilder()
                .addMiniMessageLoreLines(
                    listOf(
                        "",
                        "<gray>Current Value:",
                        if (conditions?.size ?: 0 > 0) {
                            "<green>${conditions!!.size!!} conditions"
                        } else {
                            "<red>No conditions"
                        },
                        "",
                        "<yellow>Click to change!"
                    )
                ), 10)
            .addIngredient('n', (data["not"] ?: false).let {
                if (it as Boolean) GuiItems.NOT_GREEN
                else GuiItems.NOT_RED
            }.createItemBuilder()
                .addMiniMessageLoreLines(
                    listOf(
                        "<gray>When enabled the conditions",
                        "<gray>will be inverted",
                        "",
                        "<gray>Current Value:",
                        if (data["not"] as Boolean) {
                            "<green>Yes"
                        } else {
                            "<red>No"
                        },
                    )
                ), 11)
            .addIngredient('&', (data["matchAnyCondition"] ?: false).let {
                if (it as Boolean) GuiItems.MATCH_ANY_CONDITION_GREEN
                else GuiItems.MATCH_ANY_CONDITION_RED
            }.createItemBuilder().addMiniMessageLoreLines(
                listOf(
                    "<gray>When enabled only one",
                    "<gray>condition needs to match,",
                    "<gray>otherwise all conditions",
                    "<gray>must match",
                    "",
                    "<gray>Current Value:",
                    if (data["matchAnyCondition"] as Boolean) {
                        "<green>Yes"
                    } else {
                        "<red>No"
                    },
                )
            ), 12)
            .addIngredient('i', GuiItems.IF_ACTIONS.createItemBuilder().addMiniMessageLoreLines(
                listOf(
                    "<gray>Actions to execute if the",
                    "<gray>conditions are met",
                    "",
                    "<gray>Current Value:",
                    if (data["ifActions"] != null) {
                        "<green>${(data["ifActions"] as List<*>).size} actions"
                    } else {
                        "<red>No actions"
                    },
                    "",
                    "<yellow>Click to change!"
                )
            ), 13)
            .addIngredient('e', GuiItems.ELSE_ACTIONS.createItemBuilder().addMiniMessageLoreLines(
                listOf(
                    "<gray>Actions to execute if the",
                    "<gray>conditions are not met",
                    "",
                    "<gray>Current Value:",
                    if (data["elseActions"] != null) {
                        "<green>${(data["elseActions"] as List<*>).size} actions"
                    } else {
                        "<red>No actions"
                    },
                    "",
                    "<yellow>Click to change!"
                )
            ), 14)

        return upperGui!!
    }

    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())
            .setTitle(GuiTextures.CONDITIONALS.component)
        return window!!
    }
}