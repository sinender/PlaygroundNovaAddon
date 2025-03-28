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

class EditItemWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_ITEM_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {
        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". i . . . . . f .",
                    ". . . . . . . . .",
                    ". j e j . j c j .",
                    ". j . a a a . j .",
                    ". r r r . l l l ."
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 1)
            .addIngredient(
                'l', GuiItems.EDIT_ITEM_LORE.createItemBuilder()
                    .addLoreLines(menu?.getItem(30)?.lore() ?: emptyList()), 30
            )
            .addIngredient(
                'f', GuiItems.EDIT_ITEM_FLAGS.createItemBuilder()
                    .addLoreLines(menu?.getItem(40)?.lore() ?: emptyList()), 40
            )
            .addIngredient(
                'i', GuiItems.ITEM_TYPE.createItemBuilder()
                    .addLoreLines(menu?.getItem(41)?.lore() ?: emptyList()), 41
            )
            .addIngredient(
                'e', GuiItems.EDIT_ITEM_ENCHANTS.createItemBuilder()
                    .addLoreLines(menu?.getItem(32)?.lore() ?: emptyList()), 32
            )
            .addIngredient(
                'c', GuiItems.SET_CUSTOM_MODEL_DATA.createItemBuilder()
                    .addLoreLines(menu?.getItem(43)?.lore() ?: emptyList()), 43
            )
            .addIngredient(
                'a', GuiItems.EDIT_ITEM_ACTIONS.createItemBuilder()
                    .addLoreLines(menu?.getItem(34)?.lore() ?: emptyList()), 34
            )
            .addIngredient(
                'r', GuiItems.RENAME_ITEM.createItemBuilder()
                    .addLoreLines(menu?.getItem(28)?.lore() ?: emptyList()), 28
            )
        val allowedSlots =
            intArrayOf(13)
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
                    ". . . . u . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
        menu?.getItem(37)?.type?.let { type ->
            if (type.name == "LIME_DYE") {
                lowerGui!!.addIngredient(
                    'u', GuiItems.UNBREAKABLE_ITEM.createItemBuilder()
                        .addLoreLines(menu?.getItem(37)?.lore() ?: emptyList()), 37
                )
            } else {
                lowerGui!!.addIngredient(
                    'u', GuiItems.BREAKABLE_ITEM.createItemBuilder()
                        .addLoreLines(menu?.getItem(37)?.lore() ?: emptyList()), 37
                )
            }
        }
        return lowerGui!!
    }
}