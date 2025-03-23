package com.example.guitextures

import com.example.ExampleAddon
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import org.joml.Vector3d
import org.joml.Vector3f
import xyz.xenondevs.nova.addon.registry.ItemRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage
import xyz.xenondevs.nova.resources.builder.data.TintSource
import xyz.xenondevs.nova.resources.builder.layout.item.ConditionItemModelProperty
import xyz.xenondevs.nova.resources.builder.model.Model
import xyz.xenondevs.nova.world.item.NovaItem
import xyz.xenondevs.nova.world.item.behavior.ItemBehaviorHolder


@Init(stage = InitStage.PRE_PACK)
object GuiItems : ItemRegistry by ExampleAddon.registry {
    //Conditional GUI Items
    val CONDITIONS = emptyItem("conditions", "§aConditions")
    val NOT_GREEN = guiItem("conditionals/not_green", "§aNot")
    val NOT_RED = guiItem("conditionals/not_red", "§cNot")
    val MATCH_ANY_CONDITION_GREEN = guiItem("conditionals/match_any_condition_green", "§aMatch Any Condition")
    val MATCH_ANY_CONDITION_RED = guiItem("conditionals/match_any_condition_red", "§cMatch Any Condition")
    val IF_ACTIONS = emptyItem("if", "§aIf Actions")
    val ELSE_ACTIONS = emptyItem("else", "§aElse Actions")
    val COPY_TO_CLIPBOARD = emptyItem("copy", "§aCopy to Clipboard")
    val IMPORT_FROM_CLIPBOARD = emptyItem("import", "§bImport from Clipboard")
    val SET_COMMENT = emptyItem("comment", "§dSet Comment")

    //Action GUI Items
    val ADD_ACTION = guiItem("action/add_action", "§aAdd Action")
    val EXPORT_ACTION = guiItem("action/export", "§aExport Actions")
    val IMPORT_ACTION = guiItem("action/import", "§bImport Actions")
    val IMPORT_AUTO = guiItem("action/import_auto", "§bImport Actions from Websocket")
    val NO_ACTION = guiItem("action/no_action", "§cNo Actions!", false, 3)
    val NO_ACTION_EMPTY = emptyItem("no_action", "§cNo Actions!")
    val RESTORE = guiItem("action/restore", "§aRestore")

    //Edit Item GUI Items
    val ITEM_TYPE = emptyItem("item_type", "§eSet Item Type!")
    val EDIT_ITEM_ENCHANTS = emptyItem("edit_enchants", "§dEdit Enchantments")
    val EDIT_ITEM_ACTIONS = emptyItem("edit_actions", "§aEdit Actions")
    val EDIT_ITEM_FLAGS = emptyItem("edit_flags", "§fEdit Item Flags")
    val SET_CUSTOM_MODEL_DATA = emptyItem("set_custom_model_data", "§dSet Custom Model Data")
    val RENAME_ITEM = emptyItem("rename_item", "§eRename Item")
    val EDIT_ITEM_LORE = emptyItem("edit_lore", "§bEdit Lore")
    val BREAKABLE_ITEM = guiItem("edit.item/breakable", "§cBreakable")
    val UNBREAKABLE_ITEM = guiItem("edit.item/unbreakable", "§aUnbreakable")

    //Action Edit GUI Items
    val ADD_EXPRESSION = guiItem("action.settings/add_expression", "§aAdd Expression", false, 3)
    val ADD_EXPRESSION_EMPTY = emptyItem("add_expression", "§aAdd Expression")
    val LIMIT_REACHED = guiItem("action.settings/limit_reached", "§cLimit Reached", false, 3)
    val LIMIT_REACHED_EMPTY = emptyItem("limit_reached", "§cLimit Reached")

    //Action Enum GUI Items
    val INVOKERS_LOCATION = emptyItem("invokers_location", "§eInvokers Location")
    val CUSTOM_LOCATION = emptyItem("custom_location", "§bCustom Location")
    val HOUSE_SPAWN_LOCATION = emptyItem("house_spawn_location", "§aHouse Spawn Location")

    //Systems > Functions GUI Items
    val ADD_FUNCTION = guiItem("functions/add_function", "§aAdd Function")
    val NO_ITEMS = guiItem("functions/no_items", "§aNo Items!", false, 3)
    val NO_ITEMS_EMPTY = emptyItem("no_items", "§aNo Items!")

    //Systems > Regions GUI Items
    val CREATE_REGION = guiItem("regions/create_region", "§aCreate Region")
        //Region Edit Gui Items
        val DELETE_REGION = emptyItem("delete_region", "§cDelete Region")
        val EXIT_ACTIONS_REGION = emptyItem("exit_actions", "§cExit Actions")
        val ENTRY_ACTIONS_REGION = emptyItem("entry_actions", "§bEntry Actions")
        val PVP_SETTINGS_REGION = emptyItem("pvp_settings", "§7Pvp Settings")
        val TELEPORT_REGION = emptyItem("teleport_region", "§dTeleport to Region")
        val RENAME_REGION = emptyItem("rename_region", "§eRename Region")

    //Systems > Scoreboard GUI Items
    val TITLE = emptyItem("title", "§bTitle")
    val NEW_LINE = emptyItem("add_line", "§aAdd Line")

    //Systems > Commands GUI Items
    val CREATE_COMMAND = guiItem("commands/create_command", "§aCreate Command")

    //Systems > Inventory Layouts GUI Items
    val CREATE_LAYOUT = guiItem("layouts/create_layout", "§aCreate Layout")

    //Systems > Teams GUI Items
    val CREATE_TEAM = guiItem("teams/create_team", "§aCreate Team")

    //Systems > Custom Menus GUI Items
    val CREATE_MENU = guiItem("custommenus/create_menu", "§aCreate Menu")

    //Systems > NPCs GUI Items
    val CREATE_NPC = guiItem("npcs/create_npc", "§aCreate NPC")

    //Playground Menu GUI Items
    val PLAYER_LISTING = emptyItem("player_listing", "§ePlayer Listing")
    val BUILD_MODE = emptyItem("build_mode", "§aMode: §eBuild Mode")
    val BROWSER = emptyItem("browser", "§bTravel to someone else's house")
    val HEADS = emptyItem("heads", "§aHeads")
    val SETTINGS = emptyItem("settings", "§7Settings")
    val GROUPS = emptyItem("groups", "§dGroups")
    val PROTOOLS = emptyItem("protools", "§5Protools")
    val CUSTOM_ITEMS = emptyItem("custom_items", "§cCustom Items")
    val ITEMS = emptyItem("items", "§bItems")
    val SYSTEMS = emptyItem("systems", "§eSystems")
    val VISIBILITY_PUBLIC = guiItem("playground.menu/visibility_public", "§aVisiting Rules", false, 3)
    val VISIBILITY_PUBLIC_EMPTY = emptyItem("visibility_public", "§aVisiting Rules")
    val VISIBILITY_PRIVATE = guiItem("playground.menu/visibility_private", "§aVisiting Rules", false, 3)
    val VISIBILITY_PRIVATE_EMPTY = emptyItem("visibility_private", "§aVisiting Rules")

    //General GUI Items
    val PREVIOUS_PAGE = guiItem("left_arrow", "§aPrevious Page")
    val NEXT_PAGE = guiItem("right_arrow", "§aNext Page")
    val BACK = emptyItem("back", "§cGo Back")
    val SEARCH = emptyItem("search", "§eSearch")
    val NOT_CLICKABLE = emptyItem("not_clickable", "")

    //Gui Visuals
    val TP_ONE = guiItem("gui.visuals/tp_one", "", false, 4)
    val TP_TWO = guiItem("gui.visuals/tp_two", "", false, 4)

    private fun emptyItem(
        name: String,
        localizedName: String? = "",
        stretched: Boolean = false
    ): NovaItem = item("gui/opaque/$name") {
        if (localizedName == null) {
            name(null)
        } else localizedName(localizedName)
        hidden(true)
        modelDefinition {
            model = buildModel { createGuiModel(false, stretched, "item/gui/empty") }
        }
    }

    private fun guiItem(
        name: String,
        localizedName: String? = "",
        stretched: Boolean = false,
        slots: Int = 1,
    ): NovaItem = item("gui/opaque/$name") {
        if (localizedName == null) {
            name(null)
        } else localizedName(localizedName)
        hidden(true)
        var display = when (slots) {
            2 -> Model.Display(
                scale = Vector3d(2.0, 1.0, 1.0),
                translation = Vector3d(8.0, 0.0, 0.0)
            )
            3 -> Model.Display(
                scale = Vector3d(3.3, 1.0, 1.0),
                translation = Vector3d(18.0, 2.0, 0.0)
            )
            4 -> Model.Display(
                scale = Vector3d(1.0,1.0,1.0),
                translation = Vector3d(0.0,36.0,0.0)
            )
            else -> Model.Display(
                scale = Vector3d(1.0, 1.0, 1.0),
                translation = Vector3d(0.0, 0.0, 0.0)
            )
        }

        modelDefinition {
            model = buildModel {
                createGuiModel(false, stretched, "item/gui/$name", display = display)
            }
        }
    }
}