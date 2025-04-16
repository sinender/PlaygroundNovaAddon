package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class OptionsWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {
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
                    "x . . . . . . . z",
                    "o . . . . . . . f",
                    "l . . s s s . . r",
                )
            )
            .addIngredient(
                'l', if (menu?.getItem(45)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.PREVIOUS_PAGE.createItemBuilder()
                        .addLoreLines(menu?.getItem(45)?.lore() ?: emptyList())
                }, 45
            )
            .addIngredient(
                'r', if (menu?.getItem(53)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.NEXT_PAGE.createItemBuilder()
                        .addLoreLines(menu?.getItem(53)?.lore() ?: emptyList())
                }, 53
            )
            .addIngredient(
                'o', if (menu?.getItem(36)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.PREVIOUS_PAGE.createItemBuilder()
                        .addLoreLines(menu?.getItem(36)?.lore() ?: emptyList())
                }, 36
            )
            .addIngredient(
                'f', if (menu?.getItem(44)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.NEXT_PAGE.createItemBuilder()
                        .addLoreLines(menu?.getItem(44)?.lore() ?: emptyList())
                }, 44
            )
            .addIngredient(
                'x', if (menu?.getItem(27)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.PREVIOUS_PAGE.createItemBuilder()
                        .addLoreLines(menu?.getItem(27)?.lore() ?: emptyList())
                }, 27
            )
            .addIngredient(
                'z', if (menu?.getItem(35)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.NEXT_PAGE.createItemBuilder()
                        .addLoreLines(menu?.getItem(35)?.lore() ?: emptyList())
                }, 35
            )
        if (menu?.getItem(13)?.itemMeta?.displayName == "§eInvokers Location") {
            upperGui!!.addIngredient('i', GuiItems.INVOKERS_LOCATION.createItemBuilder(), 13)
            upperGui!!.addIngredient('c', GuiItems.CUSTOM_LOCATION.createItemBuilder(), 10)
            upperGui!!.addIngredient('h', GuiItems.HOUSE_SPAWN_LOCATION.createItemBuilder(), 11)
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
        } else {
            upperGui!!.addIngredient('i', empty_slot)
            upperGui!!.addIngredient('c', empty_slot)
            upperGui!!.addIngredient('h', empty_slot)
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