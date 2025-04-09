package com.example.listeners

import com.al3x.housing2.Events.MenuClickEvent
import com.al3x.housing2.Events.MenuSetupItemsEvent
import com.al3x.housing2.Events.OpenMenuEvent
import com.example.ExamplePlugin.Companion.windows
import com.example.window.*
import com.example.window.windows.*
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class OpenMenuListener : Listener {
    @EventHandler
    fun onOpenActionMenu(event: OpenMenuEvent) {
        //Window registration
        val window: AlternativeWindow = when (event.menu.javaClass.simpleName) {
            "GroupsMenu" -> GroupsWindow()
            "GroupEditMenu" -> EditGroupWindow()
            "PermissionsMenu" -> EditPermissionsWindow()
            "PlayerListingMenu" -> PlayerListingWindow()
            "EditPlayerMenu" -> EditPlayerWindow()
            "ActionsMenu" -> ActionsWindow()
            "AddActionMenu" -> AddActionsWindow()
            "ActionClipboardMenu" -> ActionClipboardWindow()
            "AddConditionMenu" -> AddActionsWindow()
            "FunctionsMenu" -> FunctionsWindow()
            "FunctionSettingsMenu" -> EditFunctionWindow()
            "HousingMenu" -> PlaygroundWindow()
            "RegionsMenu" -> RegionsWindow()
            "RegionEditMenu" -> EditRegionWindow()
            "EventActionsMenu" -> EventActionsWindow()
            "ScoreboardMenu" -> ScoreboardWindow()
            "CommandArgumentsEditMenu" -> EditArgumentsWindow()
            "CommandsMenu" -> CommandsWindow()
            "CommandEditMenu" -> EditCommandWindow()
            "LayoutsMenu" -> LayoutsWindow()
            "LayoutEditMenu" -> EditLayoutWindow()
            "ChangeArmorMenu" -> ChangeArmorWindow()
            "TeamsMenu" -> TeamsWindow()
            "TeamEditMenu" -> EditTeamWindow()
            "CustomMenusMenu" -> CustomMenusWindow()
            "CustomMenuEditMenu" -> EditMenuWindow()
            "ChangeMenuSizeMenu" -> MenuSizeWindow()
            "NPCsMenu" -> NPCsWindow()
            "NPCMenu" -> EditNpcWindow()
            "SystemsMenu" -> SystemsWindow()
            "ActionEditMenu" -> ChatActionSettingsWindow()
            "ActionEnumMenu" -> OptionsWindow()
            "HouseBrowserMenu" -> BrowserWindow()
            "MyHousesMenu" -> MyCreationsWindow()
            "EditHouseMenu" -> EditCreationWindow()
            "ConfirmMenu" -> ConfirmationWindow()
            "EditItemMainMenu" -> EditItemWindow()
            "EnumMenu" -> SelectItemWindow()
            else -> return
        }

        window.menu = event.menu
        event.menu.setupItems()
        window.createWindow().open(event.player)

        event.isCancelled = true
        windows[event.player.uniqueId] = window
    }

    @EventHandler
    fun onMenuSetupPost(event: MenuSetupItemsEvent.Post) {
        var window = windows[event.player.uniqueId]
        if (window == null) return

        if (window.menu != event.menu) return

        window.createWindow().open(event.player)
    }

    @EventHandler
    fun onMenuClick(event: MenuClickEvent) {
        var player = event.whoClicked as Player

        var window = windows[player.uniqueId]
        if (window == null) return

        if (window.menu != event.menu) return
        event.isCancelled = true

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
                                event.isStopped = true
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
                                    event.isStopped = true
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
                    for (j in row.indices) {
                        if (row[j].length == 1) {
                            if (event.slot == i * 9 + j) {
                                val ingredient = window.ingredients[window.upperGui]?.firstOrNull {
                                    it.char == row[j][0]
                                }

                                if (ingredient != null) {
                                    event.isStopped = true
                                    val clickEvent = InventoryClickEvent(
                                        event.view,
                                        event.slotType,
                                        ingredient.slot,
                                        event.click,
                                        event.action,
                                        event.hotbarButton
                                    )
                                    event.menu.handleExternalClick(clickEvent)
                                } else {
                                    val clickEvent = InventoryClickEvent(
                                        event.view,
                                        event.slotType,
                                        event.slot,
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