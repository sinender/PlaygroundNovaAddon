package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class OptionsWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        if (menu?.getItem(13)?.itemMeta?.displayName == "§eInvokers Location") {
            window = Window.split()
                .setTitle(GuiTextures.TELEPORT_OPTIONS.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else {
            window = Window.split()
                .setTitle(GuiTextures.GENERIC_OPTIONS.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        }
        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {
        var empty_slot = DefaultGuiItems.INVISIBLE_ITEM.createItemBuilder()

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". i . c c c . h .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . s s s . . .",
                )
            )
        if (menu?.getItem(13)?.itemMeta?.displayName == "§eInvokers Location") {
            upperGui!!.addIngredient('i', GuiItems.INVOKERS_LOCATION.createItemBuilder(), 13)
            upperGui!!.addIngredient('c', GuiItems.CUSTOM_LOCATION.createItemBuilder(), 10)
            upperGui!!.addIngredient('h', GuiItems.HOUSE_SPAWN_LOCATION.createItemBuilder(), 11)
        } else {
            upperGui!!.addIngredient('i', empty_slot)
            upperGui!!.addIngredient('c', empty_slot)
            upperGui!!.addIngredient('h', empty_slot)
        }
            upperGui!!.addIngredient(
                's', GuiItems.SEARCH.createItemBuilder()
                    .addLoreLines(menu?.getItem(48)?.lore() ?: emptyList()), 48
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