package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class MyCreationsWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.MY_CREATIONS_WINDOW.component)
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
                )
            )
        val allowedSlots =
            intArrayOf(10, 11, 12, 13, 14, 15, 16)
        upperGui!!.addModifier {
            for (slot in allowedSlots) {
                if (menu?.getItem(slot)?.isEmpty == false) {
                    it.setItem(
                        slot, Item.simple(
                            menu?.getItem(slot) ?: DefaultGuiItems.INVISIBLE_ITEM.createItemStack(1)
                        )
                    )
                }
            }
        }
        return upperGui!!
    }

    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
        return lowerGui!!
    }
}