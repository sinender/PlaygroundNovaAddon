package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.util.equalsAny
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class TimeSelectorWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {

            if (menu?.getItem(39)?.lore?.any { stripColor(it) == "Current: Enabled" } == true) {
                window = Window.split()
                    .setTitle(GuiTextures.TIME_SELECTOR_E_WINDOW.component)
                    .setUpperGui(createUpperGui())
                    .setLowerGui(createLowerGui())
            } else {
                window = Window.split()
                    .setTitle(GuiTextures.TIME_SELECTOR_D_WINDOW.component)
                    .setUpperGui(createUpperGui())
                    .setLowerGui(createLowerGui())
            }

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". s s . . . 0 0 .",
                    "l s s l l l 0 0 l",
                    "l l l l l l l l l",
                    "a l c l f l h l k",
                    "1 2 3 4 5 6 7 8 9",
                    ". b . d . g . j .",
                )
            )
            .addIngredient('l', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)

            .addIngredient('2', GuiItems.NOT_CLICKABLE.createItemBuilder(), 19)
            .addIngredient('3', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('4', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('5', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('6', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('7', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('8', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('9', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('a', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('b', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('c', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('d', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('e', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('f', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('g', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('h', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('i', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('k', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)

            .addIngredient('s', GuiItems.SET_TIME.createItemBuilder()
                .addLoreLines(menu?.getItem(41)?.lore() ?: emptyList()), 41
            )
        if (menu?.getItem(39)?.lore?.any { stripColor(it) == "Current: Enabled" } == true) {
            upperGui!!.addIngredient('0', GuiItems.TOGGLE_DAYLIGHT_CYCLE_E.createItemBuilder()
                .addLoreLines(menu?.getItem(39)?.lore() ?: emptyList()), 39
            )
        } else {
            upperGui!!.addIngredient('0', GuiItems.TOGGLE_DAYLIGHT_CYCLE_D.createItemBuilder()
                .addLoreLines(menu?.getItem(39)?.lore() ?: emptyList()), 39
            )
        }
        if (menu?.getItem(18)!!?.getData()?.itemType?.name.equals("shulker_shell")) {
            upperGui!!.addIngredient(
                '1', GuiItems.SELECTED_TIME.createItemBuilder()
                    .addLoreLines(menu?.getItem(18)?.lore() ?: emptyList()), 18
            )
        } else {
            upperGui!!.addIngredient(
                '1', GuiItems.UNSELECTED_TIME.createItemBuilder()
                    .addLoreLines(menu?.getItem(18)?.lore() ?: emptyList()), 18
            )
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
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 40)
        return lowerGui!!
    }
}