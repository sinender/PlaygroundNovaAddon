package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditRegionWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_REGION_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {
        var empty_slot = DefaultGuiItems.INVISIBLE_ITEM.createItemBuilder()

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . p p . t t . .",
                    ". . j . j . j . .",
                    ". . j e e e j . .",
                    ". . . x x x . . .",
                    ". . . r r r . . .",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('p', GuiItems.PVP_SETTINGS_REGION.createItemBuilder(), 29)
            .addIngredient('t', GuiItems.TELEPORT_REGION.createItemBuilder(), 14)
            .addIngredient('e', GuiItems.ENTRY_ACTIONS_REGION.createItemBuilder(), 31)
            .addIngredient('x', GuiItems.EXIT_ACTIONS_REGION.createItemBuilder(), 33)
            .addIngredient('r', GuiItems.RENAME_REGION.createItemBuilder(), 12)

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
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 49)
            .addIngredient('d', GuiItems.DELETE_REGION.createItemBuilder(), 50)
        return lowerGui!!
    }
}