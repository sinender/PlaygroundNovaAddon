package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import org.bukkit.Material
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class SelectItemWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.SELECT_ITEM_WINDOW.component)
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
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    "l . . s s s . . r"
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
                's', GuiItems.SEARCH.createItemBuilder()
                    .addLoreLines(menu?.getItem(48)?.lore() ?: emptyList()), 48
            )
        val allowedSlots =
            intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35)
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
                    ". . . . b . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 49)
        return lowerGui!!
    }
}