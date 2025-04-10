package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import org.bukkit.ChatColor.stripColor
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class EditGroupWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal<*, *> {
        if (menu?.getItem(48)?.isEmpty != false && (menu?.getItem(50)?.isEmpty != false)) {
            window = Window.split()
                .setTitle(GuiTextures.EDIT_GROUP_AB_WINDOW.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(48)?.isEmpty != true && (menu?.getItem(50)?.isEmpty != false)) {
            window = Window.split()
                .setTitle(GuiTextures.EDIT_GROUP_B_WINDOW.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(48)?.isEmpty != true && (menu?.getItem(50)?.isEmpty != true)) {
            window = Window.split()
                .setTitle(GuiTextures.EDIT_GROUP_WINDOW.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else if (menu?.getItem(48)?.isEmpty != false && (menu?.getItem(50)?.isEmpty != true)) {
            window = Window.split()
                .setTitle(GuiTextures.EDIT_GROUP_A_WINDOW.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        } else {
            window = Window.split()
                .setTitle(GuiTextures.EDIT_GROUP_WINDOW.component)
                .setUpperGui(createUpperGui())
                .setLowerGui(createLowerGui())
        }

        return window!!
    }

    override fun createUpperGui(): Gui.Builder<*, *> {

        upperGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". j a a a a a j .",
                    ". h a a a a a m .",
                    ". j j j j j j j .",
                    ". r . . . . . n .",
                    ". . . v j k . . .",
                )
            )
            .addIngredient('j', GuiItems.NOT_CLICKABLE.createItemBuilder(), 0)
            .addIngredient('a', GuiItems.GROUP_PERMISSIONS  .createItemBuilder()
                .addLoreLines(menu?.getItem(33)?.lore() ?: emptyList()), 33
            )
            .addIngredient('m', GuiItems.GROUP_DISPLAY.createItemBuilder()
                .addLoreLines(menu?.getItem(16)?.lore() ?: emptyList()), 16
            )
            .addIngredient('h', GuiItems.RENAME_GROUP.createItemBuilder()
                .addLoreLines(menu?.getItem(10)?.lore() ?: emptyList()), 10
            )
            .addIngredient('r', GuiItems.GROUP_PREFIX.createItemBuilder()
                .addLoreLines(menu?.getItem(12)?.lore() ?: emptyList()), 12
            )
            .addIngredient('n', GuiItems.GROUP_SUFFIX.createItemBuilder()
                .addLoreLines(menu?.getItem(14)?.lore() ?: emptyList()), 14
            )
            .addIngredient('v', GuiItems.GROUP_COLOR.createItemBuilder()
                .addLoreLines(menu?.getItem(29)?.lore() ?: emptyList()), 29
            )
            .addIngredient('k', GuiItems.GROUP_PRIORITY.createItemBuilder()
                .addLoreLines(menu?.getItem(31)?.lore() ?: emptyList()), 31
            )

        return upperGui!!
    }
    override fun createLowerGui(): Gui.Builder<*, *> {
        var empty_slot = DefaultGuiItems.INVISIBLE_ITEM.createItemBuilder()

        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". . s . b . d . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 49)
            .addIngredient(
                'd', if (menu?.getItem(48)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.DELETE_GROUP.createItemBuilder()
                        .addLoreLines(menu?.getItem(48)?.lore() ?: emptyList())
                }, 48
            )
            .addIngredient(
                's', if (menu?.getItem(50)?.isEmpty != false) {
                    empty_slot
                } else {
                    GuiItems.DEFAULT_GROUP.createItemBuilder()
                        .addLoreLines(menu?.getItem(50)?.lore() ?: emptyList())
                }, 50
            )
        return lowerGui!!
    }
}