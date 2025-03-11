package com.example.window.windows

import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.window.AlternativeWindow
import net.kyori.adventure.text.Component
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.DefaultGuiItems

class ActionsWindow : AlternativeWindow() {
    override fun createWindow(): Window.Builder.Normal.Split {
        window = Window.split()
            .setTitle(GuiTextures.ACTIONS_WINDOW.component)
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
                    ". . . n f f . . .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                    "l . a s s s a . r",
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
            .addIngredient('a', GuiItems.ADD_ACTION.createItemBuilder(), 50)
            .addIngredient(
                's', GuiItems.SEARCH.createItemBuilder()
                    .addLoreLines(menu?.getItem(51)?.lore() ?: emptyList()), 51
            )

        var name = menu?.getItem(22)?.itemMeta?.displayName?.equals("§cNo Actions!") ?: false
        if (menu?.getItem(22)?.isEmpty == true || !name) {
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
            upperGui!!.addIngredient('n', GuiItems.NO_ACTION.createItemBuilder(), 22)
            upperGui!!.addIngredient('f', GuiItems.NO_ACTION_EMPTY.createItemBuilder(), 22)
        }

        return upperGui!!
    }

    override fun createLowerGui(): Gui.Builder<*, *> {
        lowerGui = Gui.normal()
            .setStructure(
                arrayListOf(
                    ". . . . . . . . .",
                    ". i a . b . e r .",
                    ". . . . . . . . .",
                    ". . . . . . . . .",
                )
            )
            .addIngredient('i', GuiItems.IMPORT_ACTION.createItemBuilder(), 48)
            .addIngredient('a', GuiItems.IMPORT_AUTO.createItemBuilder(), 47)
            .addIngredient('b', GuiItems.BACK.createItemBuilder(), 49)
            .addIngredient(
                'e', GuiItems.EXPORT_ACTION.createItemBuilder()
                    .addMiniMessageLoreLines(
                        arrayListOf(
                            "<gray>Because you have the mod",
                            "<gray>installed, you can export",
                            "<gray>the actions to a file.",
                            "",
                            "<yellow>Click to export!"
                        )
                    ), 46
            )

        if (menu?.getItem(52)?.isEmpty == false) {
            lowerGui!!.addIngredient(
                'r', GuiItems.RESTORE.createItemBuilder()
                    .addLoreLines(menu?.getItem(52)?.lore() ?: emptyList())
                    .setName(menu?.getItem(52)?.displayName() ?: Component.text("§aRestore <action/condition>")), 52
            )
        }

        return lowerGui!!
    }
}