package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditTeamWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.EDIT_TEAM_WINDOW.component)
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". r r r j d d d .",
                    ". . . . . . . . .",
                    ". p p p j c c c .",
                    ". . . . . . . . .",
                    ". s s s j f t t .",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('r', GuiItems.RENAME_TEAM.createItemBuilder()
                .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )
            .addIngredient('p', GuiItems.TEAM_PREFIX.createItemBuilder()
                .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            .addIngredient('s', GuiItems.TEAM_SUFFIX.createItemBuilder()
                .addLoreLines(menu?.getItem(15)?.lore() ?: emptyList()), 15
            )
            .addIngredient('d', GuiItems.TEAM_DISPLAY.createItemBuilder()
                .addLoreLines(menu?.getItem(29)?.lore() ?: emptyList()), 29
            )
            .addIngredient('c', GuiItems.TEAM_COLOR.createItemBuilder()
                .addLoreLines(menu?.getItem(31)?.lore() ?: emptyList()), 31
            )
        menu?.getItem(33)?.lore?.let { lore ->
            if (lore.any { stripColor(it) == "Current: Disabled" }) {
                upperGui!!.addIngredient(
                    'f', GuiItems.FFIRE_DISABLED.createItemBuilder()
                        .addLoreLines(menu?.getItem(33)?.lore() ?: emptyList()), 33
                )
                upperGui!!.addIngredient(
                    't', GuiItems.FFIRE_DISABLED_EMPTY.createItemBuilder()
                        .addLoreLines(menu?.getItem(33)?.lore() ?: emptyList()), 33
                )
            } else {
                upperGui!!.addIngredient(
                    'f', GuiItems.FFIRE_ENABLED.createItemBuilder()
                        .addLoreLines(menu?.getItem(33)?.lore() ?: emptyList()), 33
                )
                upperGui!!.addIngredient(
                    't', GuiItems.FFIRE_ENABLED_EMPTY.createItemBuilder()
                        .addLoreLines(menu?.getItem(33)?.lore() ?: emptyList()), 33
                )
            }
        }

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
            .addIngredient('d', GuiItems.DELETE_TEAM.createItemBuilder()
                .addLoreLines(menu?.getItem(48)?.lore() ?: emptyList()), 48
            )
        return lowerGui!!
    }
}