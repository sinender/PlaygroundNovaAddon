package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.ChatColor.stripColor
import org.bukkit.Material
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.resources.CharSizes
import xyz.xenondevs.nova.util.component.adventure.moveTo
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditPlayerWindow(val name: String) : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {

        val playerName = stripColor(name.substringAfterLast(' ')) ?: "No Name"
        //left x: 38, right x: 38+88
        //find the amount of space pixels to make the name in the center
        var length = CharSizes.calculateStringWidth(Key.key("minecraft:default"), playerName)
        var space = 0
        if (length > 88) {
            length = 88F
            space = 0
        } else {
            space = ((88 - length) / 2).toInt()
        }
        window = Window.split()
            .setTitle(
                GuiTextures.EDIT_PLAYER_WINDOW.getTitle(
                    Component.text()
                        .moveTo(space + 38)
                        .append(
                            Component.text(playerName)
                                .color(TextColor.color(0xE5E5E5))
                        )
                        .build()
                )
            )
            .setUpperGui(createUpperGui())
            .setLowerGui(createLowerGui())

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {
        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    "j j j j j j j j j",
                    "j k f f j t r r j",
                    ". m l l . g h h .",
                    ". b v v . o i i ."
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
        if (menu?.getItem(10)?.itemMeta?.displayName()?.equals("§cKick Player") == true) {
            upperGui!!.addIngredient(
                'o', GuiItems.CYCLE_GAMEMODE.createItemBuilder()
                    .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            upperGui!!.addIngredient(
                'i', GuiItems.CYCLE_GAMEMODE_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            upperGui!!.addIngredient(
                'g', GuiItems.CYCLE_GROUP.createItemBuilder()
                    .addLoreLines(menu?.getItem(14)?.lore() ?: emptyList()), 14
            )
            upperGui!!.addIngredient(
                'h', GuiItems.CYCLE_GROUP_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(14)?.lore() ?: emptyList()), 14
            )
            upperGui!!.addIngredient(
                't', GuiItems.CYCLE_TEAM.createItemBuilder()
                    .addLoreLines(menu?.getItem(15)?.lore() ?: emptyList()), 15
            )
            upperGui!!.addIngredient(
                'r', GuiItems.CYCLE_TEAM_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(15)?.lore() ?: emptyList()), 15
            )
            upperGui!!.addIngredient(
                'b', GuiItems.BAN_PLAYER.createItemBuilder()
                    .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            upperGui!!.addIngredient(
                'v', GuiItems.BAN_PLAYER_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            upperGui!!.addIngredient(
                'm', GuiItems.MUTE_PLAYER.createItemBuilder()
                    .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )
            upperGui!!.addIngredient(
                'l', GuiItems.MUTE_PLAYER_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )
            upperGui!!.addIngredient(
                'k', GuiItems.KICK_PLAYER.createItemBuilder()
                    .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
            upperGui!!.addIngredient(
                'f', GuiItems.KICK_PLAYER_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
        } else {
            upperGui!!.addIngredient(
                'g', GuiItems.CYCLE_GROUP.createItemBuilder()
                    .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            upperGui!!.addIngredient(
                'h', GuiItems.CYCLE_GROUP_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            upperGui!!.addIngredient(
                't', GuiItems.CYCLE_TEAM.createItemBuilder()
                    .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            upperGui!!.addIngredient(
                'r', GuiItems.CYCLE_TEAM_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(13)?.lore() ?: emptyList()), 13
            )
            upperGui!!.addIngredient(
                'm', GuiItems.BAN_PLAYER.createItemBuilder()
                    .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )
            upperGui!!.addIngredient(
                'l', GuiItems.BAN_PLAYER_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(11)?.lore() ?: emptyList()), 11
            )
            upperGui!!.addIngredient(
                'k', GuiItems.MUTE_PLAYER.createItemBuilder()
                    .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
            upperGui!!.addIngredient(
                'f', GuiItems.MUTE_PLAYER_EMPTY.createItemBuilder()
                    .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
            upperGui!!.addIngredient('o', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            upperGui!!.addIngredient('i', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            upperGui!!.addIngredient('b', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            upperGui!!.addIngredient('v', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
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
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 31)
            .addIngredient(
                'd', GuiItems.RESET_PLAYER_DATA.createItemBuilder()
                    .addLoreLines(menu?.getItem(35)?.lore() ?: emptyList()), 35
            )
        return lowerGui!!
    }
}