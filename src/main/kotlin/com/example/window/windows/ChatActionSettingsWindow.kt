package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.item.ItemProvider
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
                    "j j j j j j j j j",
                    "h h h h h h h h h",
                    "d d d s f f d d d",
                )
            )

        if (menu?.getItem(10)?.itemMeta?.displayName == "§eStat" || menu?.getItem(10)?.itemMeta?.displayName == "§eMode" || menu?.getItem(10)?.itemMeta?.displayName == "§eNumber 1" || menu?.getItem(10)?.itemMeta?.displayName == "§eString 1" || menu?.getItem(12)?.itemMeta?.displayName == "§eTarget" || menu?.getItem(10)?.itemMeta?.displayName == "§eString") {
            if (menu?.getItem(24)?.itemMeta?.displayName == "§eAmount" || menu?.getItem(24)?.itemMeta?.displayName == "§eNumber 2" || menu?.getItem(23)?.itemMeta?.displayName == "§eNumber 2" || menu?.getItem(11)?.itemMeta?.displayName == "§eStat Name" || menu?.getItem(12)?.itemMeta?.displayName == "§eTarget" || menu?.getItem(12)?.itemMeta?.displayName == "§eIndex" || menu?.getItem(10)?.itemMeta?.displayName == "§eString") {
                upperGui!!.addIngredient('s', GuiItems.LIMIT_REACHED.createItemBuilder(), 0)
                upperGui!!.addIngredient('f', GuiItems.LIMIT_REACHED_EMPTY.createItemBuilder(), 0)
            } else {
                upperGui!!.addIngredient('s', GuiItems.ADD_EXPRESSION.createItemBuilder(), 50)
                upperGui!!.addIngredient('f', GuiItems.ADD_EXPRESSION_EMPTY.createItemBuilder(), 50)
            }
            if (menu?.getItem(11)?.itemMeta?.displayName == "§eString") {
                menu?.getItem(11)?.lore?.let { lore ->
                    if (lore.any { stripColor(it) == "Middle Click to toggle expression!" }) {
                    } else {
                        upperGui!!.addIngredient('s', GuiItems.LIMIT_REACHED.createItemBuilder(), 0)
                        upperGui!!.addIngredient('f', GuiItems.LIMIT_REACHED_EMPTY.createItemBuilder(), 0)
                    }
                }
            }
        } else {
            upperGui!!.addIngredient('s', empty_slot)
            upperGui!!.addIngredient('f', empty_slot)
        }
        if (menu?.getItem(31)?.itemMeta?.displayName == "§cGo Back") {
            upperGui!!.addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            upperGui!!.addIngredient('h', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            upperGui!!.addIngredient('d', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
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
            upperGui!!.addIngredient('j', empty_slot)
            upperGui!!.addIngredient('h', empty_slot)
            upperGui!!.addIngredient('d', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
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