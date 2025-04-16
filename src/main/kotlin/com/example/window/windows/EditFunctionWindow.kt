package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditFunctionWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_FUNCTION_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". j j j j j j j .",
                    ". . d . . . i . .",
                    ". . . t f f . . .",
                    ". . . . . . . . .",
                    ". r r r . a a a .",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('d', GuiItems.EDIT_DESCRIPTION.createItemBuilder()
                .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            .addIngredient('a', GuiItems.AUTOMATIC_EXECUTIONS.createItemBuilder()
                .addLoreLines(menu?.getItem(32)?.lore() ?: emptyList()), 32
            )
            .addIngredient('r', GuiItems.RENAME_FUNCTION.createItemBuilder()
                .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
            .addIngredient('i', GuiItems.EDIT_FUNCTION_ICON.createItemBuilder()
                .addLoreLines(menu?.getItem(14)?.lore() ?: emptyList()), 14
            )
        menu?.getItem(16)?.lore?.let { lore ->
            if (lore.any { stripColor(it) == "Current: Disabled" }) {
                upperGui!!.addIngredient(
                    't', GuiItems.LOCAL.createItemBuilder()
                        .addLoreLines(menu?.getItem(16)?.lore() ?: emptyList()), 16
                )
                upperGui!!.addIngredient(
                    'f', GuiItems.LOCAL_EMPTY.createItemBuilder()
                        .addLoreLines(menu?.getItem(16)?.lore() ?: emptyList()), 16
                )
            } else {
                upperGui!!.addIngredient(
                    't', GuiItems.GLOBAL.createItemBuilder()
                        .addLoreLines(menu?.getItem(16)?.lore() ?: emptyList()), 16
                )
                upperGui!!.addIngredient(
                    'f', GuiItems.GLOBAL_EMPTY.createItemBuilder()
                        .addLoreLines(menu?.getItem(16)?.lore() ?: emptyList()), 16
                )
            }
        }

        return upperGui!!
    }
    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . b . d . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 31)
            .addIngredient('d', GuiItems.DELETE_FUNCTION.createItemBuilder()
                .addLoreLines(menu?.getItem(30)?.lore() ?: emptyList()), 30
            )
        return lowerGui!!
    }
}