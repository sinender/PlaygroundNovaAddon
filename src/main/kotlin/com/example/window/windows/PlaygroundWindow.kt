package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class PlaygroundWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.PLAYGROUND_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {
        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    "j . . . . . . . j",
                    ". . . h i c . . .",
                    ". . . s s s . . .",
                    ". . . g e p . . .",
                    "j . . . . . . . j"
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 1) //Makes the slot not clickable.
            .addIngredient('h', GuiItems.HEADS.createItemBuilder(), 20)
            .addIngredient('i', GuiItems.ITEMS.createItemBuilder(), 23)
            .addIngredient('c', GuiItems.CUSTOM_ITEMS.createItemBuilder(), 24)
            .addIngredient(
                's', GuiItems.SYSTEMS.createItemBuilder()
                    .addLoreLines(menu?.getItem(22)?.lore() ?: emptyList()), 22
            )
            .addIngredient('g', GuiItems.GROUPS.createItemBuilder(), 31)
            .addIngredient('e', GuiItems.SETTINGS.createItemBuilder(), 21)
            .addIngredient('p', GuiItems.PROTOOLS.createItemBuilder(), 13)


        return upperGui!!
    }

    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . . u f f . . .",
                    ". . . t b l . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('t', GuiItems.BROWSER.createItemBuilder(), 36)
            .addIngredient('b', GuiItems.BUILD_MODE.createItemBuilder(), 44)
            .addIngredient('l', GuiItems.PLAYER_LISTING.createItemBuilder(), 8)
        menu?.getItem(0)?.lore?.let { lore ->
            if (lore.any { stripColor(it) == "Current Privacy: PUBLIC" }) {
                lowerGui!!.addIngredient('u', GuiItems.VISIBILITY_PUBLIC.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
                lowerGui!!.addIngredient('f', GuiItems.VISIBILITY_PUBLIC_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
            } else if (lore.any { stripColor(it) == "Current Privacy: PRIVATE" }) {
                lowerGui!!.addIngredient('u', GuiItems.VISIBILITY_PRIVATE.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
                lowerGui!!.addIngredient('f', GuiItems.VISIBILITY_PRIVATE_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
            } else if (lore.any { stripColor(it) == "Current Privacy: WHITELISTED" }) {
                lowerGui!!.addIngredient('u', GuiItems.VISIBILITY_WHITELISTED.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
                lowerGui!!.addIngredient('f', GuiItems.VISIBILITY_WHITELISTED_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
            } else {
                lowerGui!!.addIngredient('u', GuiItems.VISIBILITY_PUBLIC_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
                lowerGui!!.addIngredient('f', GuiItems.VISIBILITY_PUBLIC_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(0)?.lore() ?: emptyList()), 0
                )
            }
        }
        return lowerGui!!
    }
}