package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class ScoreboardWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.SCOREBOARD_WINDOW.component)
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
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . n n n . . .",
                    ". . . t t t . . .",
                )
            )
            .addIngredient(
                't', GuiItems.TITLE.createItemBuilder()
                    .addLoreLines(menu?.getItem(39)?.lore() ?: emptyList()), 39
            )
            .addIngredient(
                'n', GuiItems.NEW_LINE.createItemBuilder()
                    .addLoreLines(menu?.getItem(41)?.lore() ?: emptyList()), 41
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
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 49)
        return lowerGui!!
    }
}