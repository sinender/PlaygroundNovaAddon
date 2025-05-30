package com.example.listeners

import com.al3x.housing2.Events.MenuClickEvent
import com.al3x.housing2.Events.MenuSetupItemsEvent
import com.al3x.housing2.Events.OpenActionMenuEvent
import com.al3x.housing2.Menus.Actions.ActionEditMenu
import com.example.ExamplePlugin.Companion.actionsWindow
import com.example.window.AlternativeActionsWindow
import com.example.window.windows.ChatActionSettingsWindow
import com.example.window.windows.actions.ConditionalWindow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class OpenActionMenuListener : Listener {
    @EventHandler
    fun onOpenActionMenu(event: OpenActionMenuEvent) {
        val window: AlternativeActionsWindow = when (event.action.name) {
            "Conditional Action" -> ConditionalWindow()
            else -> return
        }

        window.action = event.action
        window.createWindow().open(event.player)
        event.isCancelled = true
        event.menu.setupItems()
        actionsWindow[event.player.uniqueId] = window
    }

    @EventHandler
    fun onMenuSetupPost(event: MenuSetupItemsEvent.Post) {
        var window = actionsWindow[event.player.uniqueId]
        if (window == null) return

        if (event.menu !is ActionEditMenu || window.action != (event.menu as ActionEditMenu).action) return

        window.createWindow().open(event.player)
    }

    @EventHandler
    fun onMenuClick(event: MenuClickEvent) {
        if (event.menu is ActionEditMenu) {
            var player = event.whoClicked as Player

            var window = actionsWindow[player.uniqueId]
            if (window == null) return

            if (window.action != (event.menu as ActionEditMenu).action) return

            event.isCancelled = true
            event.isStopped = true

            if (event.clickedInventory == event.whoClicked.inventory) {
                window.structures[window.lowerGui]?.let {
                    var row1 = it.last().split(" ") //last row
                    for (j in 0 until row1.size) {
                        if (row1[j].length == 1) {
                            if (event.slot == j) { // 0 - 9
                                var ingredient = window.ingredients[window.lowerGui]?.first {
                                    it.char == row1[j][0]
                                }

                                if (ingredient != null) {
                                    var clickEvent = InventoryClickEvent(
                                        event.view,
                                        event.slotType,
                                        ingredient.slot,
                                        event.click,
                                        event.action,
                                        event.hotbarButton
                                    )
                                    event.menu.handleExternalClick(clickEvent)
                                }
                            }
                        }
                    }

                    //1st row to 2nd last row
                    for (i in 0 until it.size - 1) {
                        var row = it[i].split(" ")
                        for (j in 0 until row.size) {
                            if (row[j].length == 1 && row[j][0] != '.') {
                                if (event.slot == i * 9 + j + 9) { //9 - whatever the size of the last row is
                                    var ingredient = window.ingredients[window.lowerGui]?.first {
                                        it.char == row[j][0]
                                    }

                                    if (ingredient != null) {
                                        var clickEvent = InventoryClickEvent(
                                            event.view,
                                            event.slotType,
                                            ingredient.slot,
                                            event.click,
                                            event.action,
                                            event.hotbarButton
                                        )
                                        event.menu.handleExternalClick(clickEvent)
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                window.structures[window.upperGui]?.let {
                    for (i in 0 until it.size) {
                        var row = it[i].split(" ")
                        for (j in 0 until row.size) {
                            if (row[j].length == 1) {
                                if (event.slot == i * 9 + j) {
                                    var ingredient = window.ingredients[window.upperGui]?.first {
                                        it.char == row[j][0]
                                    }

                                    if (ingredient != null) {
                                        var clickEvent = InventoryClickEvent(
                                            event.view,
                                            event.slotType,
                                            ingredient.slot,
                                            event.click,
                                            event.action,
                                            event.hotbarButton
                                        )
                                        event.menu.handleExternalClick(clickEvent)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}