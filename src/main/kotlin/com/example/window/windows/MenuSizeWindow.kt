package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class MenuSizeWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {
        if (menu?.getItem(10)?.itemMeta?.hasEnchants() == true) {
            window = Window.split()
                .setTitle(GuiTextures.MENU_1.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(11)?.itemMeta?.hasEnchants() == true) {
            window = Window.split()
                .setTitle(GuiTextures.MENU_2.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(12)?.itemMeta?.hasEnchants() == true) {
            window = Window.split()
                .setTitle(GuiTextures.MENU_3.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(13)?.itemMeta?.hasEnchants() == true) {
            window = Window.split()
                .setTitle(GuiTextures.MENU_4.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(14)?.itemMeta?.hasEnchants() == true) {
            window = Window.split()
                .setTitle(GuiTextures.MENU_5.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(15)?.itemMeta?.hasEnchants() == true) {
            window = Window.split()
                .setTitle(GuiTextures.MENU_6.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else {
            window = Window.split()
                .setTitle(GuiTextures.MENU_1.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        }
        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". j j j j j j . .",
                    ". . o . t . e . .",
                    ". . . . j . . . .",
                    ". . f . i . s . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('o', GuiItems.MENU_SIZE_SELECTION.createItemBuilder()
                .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
            .addIngredient('t', GuiItems.MENU_SIZE_SELECTION.createItemBuilder()
                .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )
            .addIngredient('e', GuiItems.MENU_SIZE_SELECTION.createItemBuilder()
                .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            .addIngredient('f', GuiItems.MENU_SIZE_SELECTION.createItemBuilder()
                .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            .addIngredient('i', GuiItems.MENU_SIZE_SELECTION.createItemBuilder()
                .addLoreLines(menu?.getItem(14)?.lore() ?: emptyList()), 14
            )
            .addIngredient('s', GuiItems.MENU_SIZE_SELECTION.createItemBuilder()
                .addLoreLines(menu?.getItem(15)?.lore() ?: emptyList()), 15
            )


        return upperGui!!
    }
    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . b . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 31)
        return lowerGui!!
    }
}