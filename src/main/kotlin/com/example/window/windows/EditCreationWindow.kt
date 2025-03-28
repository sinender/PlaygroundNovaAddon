package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditCreationWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_CREATION_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . i i . d d . .",
                    ". . i i . d d . .",
                    ". . . . . . . . .",
                    ". . . c c c . . .",
                )
            )
            .addIngredient(
                'i', GuiItems.CHANGE_CREATION_ICON.createItemBuilder()
                    .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )
            .addIngredient(
                'd', GuiItems.DUPLICATE_CREATION.createItemBuilder()
                    .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            .addIngredient('c', GuiItems.DELETE_CREATION.createItemBuilder()
                .addMiniMessageLoreLines(
                    listOf(
                        "<yellow>Click to delete this creation.",
                    )
                ), 15)

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