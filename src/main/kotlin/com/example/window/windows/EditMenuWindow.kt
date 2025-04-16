package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditMenuWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_MENU_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . i i i . . .",
                    ". j j i i i j j .",
                    ". r . . . . . v .",
                    ". . j j s j j . .",
                    ". . . . . . . . .",
                    ". . . t t t . . .",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('i', GuiItems.EDIT_MENU_ITEMS.createItemBuilder()
                .addLoreLines(menu?.getItem(15)?.lore() ?: emptyList()), 15
            )
            .addIngredient('r', GuiItems.REFRESH_RATE.createItemBuilder()
                .addLoreLines(menu?.getItem(33)?.lore() ?: emptyList()), 33
            )
            .addIngredient('s', GuiItems.CHANGE_MENU_SIZE.createItemBuilder()
                .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            .addIngredient('v', GuiItems.VIEW_MENU.createItemBuilder()
                .addLoreLines(menu?.getItem(32)?.lore() ?: emptyList()), 32
            )
            .addIngredient('t', GuiItems.TITLE.createItemBuilder()
                .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )

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
            .addIngredient('d', GuiItems.DELETE_MENU.createItemBuilder()
                .addLoreLines(menu?.getItem(30)?.lore() ?: emptyList()), 30
            )
        return lowerGui!!
    }
}