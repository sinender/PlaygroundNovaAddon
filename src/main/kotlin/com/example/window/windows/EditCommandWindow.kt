package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditCommandWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_COMMAND_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . j . j . j . .",
                    ". . p p p p p . .",
                    ". . a a a a a . .",
                    ". . . r r r . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('p', GuiItems.EDIT_COMMAND_PRIORITY.createItemBuilder()
                .addLoreLines(menu?.getItem(15)?.lore() ?: emptyList()), 15
            )
            .addIngredient('a', GuiItems.EDIT_ARGUMENTS.createItemBuilder()
                .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            .addIngredient('r', GuiItems.RENAME_COMMAND.createItemBuilder()
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
            .addIngredient('d', GuiItems.DELETE_COMMAND.createItemBuilder()
                .addLoreLines(menu?.getItem(30)?.lore() ?: emptyList()), 30
            )
        return lowerGui!!
    }
}