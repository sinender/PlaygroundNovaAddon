package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditNpcWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_NPC_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    "i . . . . . . . .",
                    ". j . a a a . j .",
                    ". h . a a a . m .",
                    ". j . j . j . j .",
                    ". r . . . . . n .",
                    ". . t j s j l . j",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('i', GuiItems.NPC_INFO.createItemBuilder()
                .addLoreLines(menu?.getItem(48)?.lore() ?: emptyList()), 48
            )
            .addIngredient('a', GuiItems.NPC_ACTIONS.createItemBuilder()
                .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            .addIngredient('m', GuiItems.NPC_NAME.createItemBuilder()
                .addLoreLines(menu?.getItem(32)?.lore() ?: emptyList()), 32
            )
            .addIngredient('h', GuiItems.NPC_HOLO.createItemBuilder()
                .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
            .addIngredient('r', GuiItems.NPC_ARMOR.createItemBuilder()
                .addLoreLines(menu?.getItem(16)?.lore() ?: emptyList()), 16
            )
            .addIngredient('n', GuiItems.NPC_NAVIGATION.createItemBuilder()
                .addLoreLines(menu?.getItem(34)?.lore() ?: emptyList()), 34
            )
            .addIngredient('t', GuiItems.NPC_TYPE.createItemBuilder()
                .addLoreLines(menu?.getItem(30)?.lore() ?: emptyList()), 30
            )
            .addIngredient('s', GuiItems.NPC_SKIN.createItemBuilder()
                .addLoreLines(menu?.getItem(14)?.lore() ?: emptyList()), 14
            )
        menu?.getItem(48)?.lore?.let { lore ->
            if (lore.any { stripColor(it) == "Look at Players: Yes" }) {
                upperGui!!.addIngredient(
                    'l', GuiItems.NPC_LOOK_TRUE.createItemBuilder()
                        .addMiniMessageLoreLines(
                            listOf(
                                "<gray>Current: <green>True",
                                "",
                                "<yellow>Click to toggle."
                            )
                        ), 28)
            } else {
                upperGui!!.addIngredient(
                    'l', GuiItems.NPC_LOOK_FALSE.createItemBuilder()
                        .addMiniMessageLoreLines(
                            listOf(
                                "<gray>Current: <red>False",
                                "",
                                "<yellow>Click to toggle."
                            )
                        ), 28)
            }
        }

        return upperGui!!
    }
    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . s . b . d . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('b', GuiItems.CLOSE.createItemBuilder(), 49)
            .addIngredient('d', GuiItems.DELETE_NPC.createItemBuilder()
                .addLoreLines(menu?.getItem(53)?.lore() ?: emptyList()), 53
            )
            .addIngredient('s', GuiItems.NPC_SETTINGS.createItemBuilder()
                .addLoreLines(menu?.getItem(50)?.lore() ?: emptyList()), 50
            )
        return lowerGui!!
    }
}