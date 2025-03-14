package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class ChatActionSettingsWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.CHAT_ACTION_SETTINGS.component)
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
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    "c c c c c c c c c",
                    "h h h h h h h h h",
                    "d d d s f f d d d",
                )
            )
        if (menu?.getItem(10)?.itemMeta?.displayName == "§eStat") {
            upperGui!!.addIngredient('s', GuiItems.ADD_EXPRESSION.createItemBuilder(), 50)
            upperGui!!.addIngredient('f', GuiItems.ADD_EXPRESSION_EMPTY.createItemBuilder(), 50)
            upperGui!!.addIngredient('d', empty_slot)
        } else {
            upperGui!!.addIngredient('s', empty_slot)
            upperGui!!.addIngredient('f', empty_slot)
            upperGui!!.addIngredient('d', empty_slot)
        }
        if (menu?.getItem(40)?.itemMeta?.displayName == "§cGo Back") {
            upperGui!!.addIngredient('h', empty_slot)
            upperGui!!.addIngredient('d', empty_slot)
            upperGui!!.addIngredient('s', empty_slot)
            upperGui!!.addIngredient('f', empty_slot)
        }
        if (menu?.getItem(31)?.itemMeta?.displayName == "§cGo Back") {
            upperGui!!.addIngredient('h', empty_slot)
            upperGui!!.addIngredient('c', empty_slot)
            upperGui!!.addIngredient('d', empty_slot)
            upperGui!!.addIngredient('s', empty_slot)
            upperGui!!.addIngredient('f', empty_slot)
            val allowedSlots =
                intArrayOf(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25)
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
        } else {
            val allowedSlots =
                intArrayOf(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34)
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
        }
        return upperGui!!
    }

    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". c i . b . s . .",
                    ". . . . . . . . .",
                    ". . . . . . . . ."
                )
            )
        if (menu?.getItem(31)?.itemMeta?.displayName == "§cGo Back") {
            lowerGui!!.addIngredient('c', GuiItems.COPY_TO_CLIPBOARD.createItemBuilder(), 36-9)
            lowerGui!!.addIngredient('i', GuiItems.IMPORT_FROM_CLIPBOARD.createItemBuilder(), 37-9)
            lowerGui!!.addIngredient('b', GuiItems.BACK.createItemBuilder(), 40-9)
            lowerGui!!.addIngredient('s', GuiItems.SET_COMMENT.createItemBuilder(), 44-9)
        } else if (menu?.getItem(40)?.itemMeta?.displayName == "§cGo Back") {
            lowerGui!!.addIngredient('c', GuiItems.COPY_TO_CLIPBOARD.createItemBuilder(), 36)
            lowerGui!!.addIngredient('i', GuiItems.IMPORT_FROM_CLIPBOARD.createItemBuilder(), 37)
            lowerGui!!.addIngredient('b', GuiItems.BACK.createItemBuilder(), 40)
            lowerGui!!.addIngredient('s', GuiItems.SET_COMMENT.createItemBuilder(), 44)
        } else {
            lowerGui!!.addIngredient('c', GuiItems.COPY_TO_CLIPBOARD.createItemBuilder(), 36+9)
            lowerGui!!.addIngredient('i', GuiItems.IMPORT_FROM_CLIPBOARD.createItemBuilder(), 37+9)
            lowerGui!!.addIngredient('b', GuiItems.BACK.createItemBuilder(), 40+9)
            lowerGui!!.addIngredient('s', GuiItems.SET_COMMENT.createItemBuilder(), 44+9)
        }

        return lowerGui!!
    }
}