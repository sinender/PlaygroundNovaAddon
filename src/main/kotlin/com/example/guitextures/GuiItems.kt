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
    //Groups GUI Items
    val CREATE_GROUP = emptyItem("create_group", "§bCreate Group")

    //Edit Group GUI Items
    val RENAME_GROUP = emptyItem("rename_group", "§eRename Group")
    val DELETE_GROUP = emptyItem("delete_group", "§cDelete Group")
    val DEFAULT_GROUP = emptyItem("default_group", "§bDefault Group")
    val GROUP_DISPLAY = emptyItem("group_display", "§bChange Display Name")
    val GROUP_PREFIX = emptyItem("group_prefix", "§dChange Prefix")
    val GROUP_SUFFIX = emptyItem("group_suffix", "§dChange Suffix")
    val GROUP_COLOR = emptyItem("group_color", "§fChange Color")
    val GROUP_PRIORITY = emptyItem("group_priority", "§aChange Priority")
    val GROUP_PERMISSIONS = emptyItem("group_permissions", "§aEdit Permissions")

    //Edit Player GUI Items
    val KICK_PLAYER = guiItem("edit.player/kick", "§cKick Player", false, 3)
    val KICK_PLAYER_EMPTY = emptyItem("kick_player","§cKick Player")
    val MUTE_PLAYER = guiItem("edit.player/mute", "§cMute Player", false, 3)
    val MUTE_PLAYER_EMPTY = emptyItem("mute_player","§cMute Player")
    val BAN_PLAYER = guiItem("edit.player/ban", "§cBan Player", false, 3)
    val BAN_PLAYER_EMPTY = emptyItem("ban_player","§cBan Player")
    val CYCLE_TEAM = guiItem("edit.player/team", "§eCycle Team", false, 3)
    val CYCLE_TEAM_EMPTY = emptyItem("cycle_team","§eCycle Team")
    val CYCLE_GROUP = guiItem("edit.player/group", "§eCycle Group", false, 3)
    val CYCLE_GROUP_EMPTY = emptyItem("cycle_group","§eCycle Group")
    val CYCLE_GAMEMODE = guiItem("edit.player/gamemode", "§eCycle Gamemode", false, 3)
    val CYCLE_GAMEMODE_EMPTY = emptyItem("cycle_gamemode","§eCycle Gamemode")
    val RESET_PLAYER_DATA = emptyItem("reset_player_data","§cReset Player Data")

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
    val EXPORT_ACTION = guiItem("action/export", "§dExport Actions")
    val IMPORT_ACTION = guiItem("action/import", "§dImport Actions")
    val IMPORT_AUTO = guiItem("action/import_auto", "§bImport Actions from Websocket")
    val NO_ACTION = guiItem("action/no_action", "§cNo Actions!", false, 3)
    val NO_ACTION_EMPTY = emptyItem("no_action", "§cNo Actions!")
    val RESTORE = guiItem("action/restore", "§aRestore")

    //Edit Creation GUI Items
    val CHANGE_CREATION_ICON = emptyItem("change_creation", "§aChange Icon")
    val DUPLICATE_CREATION = emptyItem("duplicate_creation", "§bDuplicate Creation")
    val DELETE_CREATION = emptyItem("delete_creation", "§cDelete Creation")

    //Confirmation GUI Items
    val CONFIRM = emptyItem("cancel", "§aConfirm")
    val CANCEL = emptyItem("confirm", "§cCancel")

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
    val NO_ITEMS = guiItem("functions/no_items", "§cNo Items!", false, 3)
    val NO_ITEMS_EMPTY = emptyItem("no_items", "§cNo Items!")

    val NO_ITEMS_ARG = guiItem("functions/no_items_arg", "§cNo Items!", false, 3)
    val NO_ITEMS_ARG_EMPTY = emptyItem("no_items_arg", "§cNo Items!")

    //Systems > Regions GUI Items
    val CREATE_REGION = guiItem("regions/create_region", "§aCreate Region")
        //Region Edit Gui Items
        val DELETE_REGION = emptyItem("delete_region", "§cDelete Region")
        val EXIT_ACTIONS_REGION = emptyItem("exit_actions", "§cExit Actions")
        val ENTRY_ACTIONS_REGION = emptyItem("entry_actions", "§bEntry Actions")
        val PVP_SETTINGS_REGION = emptyItem("pvp_settings", "§7Pvp Settings")
        val TELEPORT_REGION = emptyItem("teleport_region", "§dTeleport to Region")
        val RENAME_REGION = emptyItem("rename_region", "§eRename Region")

        //Command Edit Gui Items
        val DELETE_COMMAND = emptyItem("delete_command", "§cDelete Command")
        val EDIT_ARGUMENTS = emptyItem("edit_args", "§aEdit Arguments")
        val EDIT_COMMAND_PRIORITY = emptyItem("edit_command_priority", "§fEdit Group Priority")
        val RENAME_COMMAND = emptyItem("rename_command", "§eRename Command")

        //Function Edit Gui Items
        val DELETE_FUNCTION = emptyItem("delete_function", "§cDelete Function")
        val EDIT_DESCRIPTION = emptyItem("edit_desc", "§7Edit Description")
        val EDIT_FUNCTION_ICON = emptyItem("edit_icon", "§eEdit Icon")
        val LOCAL = guiItem("functions/local", "§bToggle Global", false, 3)
        val LOCAL_EMPTY = emptyItem("local_empty", "§bToggle Global")
        val GLOBAL = guiItem("functions/global", "§bToggle Global", false, 3)
        val GLOBAL_EMPTY = emptyItem("global_empty", "§bToggle Global")
        val AUTOMATIC_EXECUTIONS = emptyItem("automatic_execution", "§aAutomatic Executions")
        val RENAME_FUNCTION = emptyItem("rename_function", "§eRename Function")

        //Layout Edit Gui Items
        val DELETE_LAYOUT = emptyItem("delete_layout", "§cDelete Layout")
        val SAVE_LAYOUT = emptyItem("save_layout", "§aSave Layout")
        val IMPORT_LAYOUT = emptyItem("import_layout", "§bImport Layout")
        val APPLY_LAYOUT = emptyItem("apply_layout", "§dApply Layout")
        val ARMOR_LAYOUT = emptyItem("edit_layout_armor", "§7Change Armor")
        val OFFHAND_LAYOUT = emptyItem("edit_layout_offhand", "§7Change Offhand")

        //Team Edit Gui Items
        val DELETE_TEAM = emptyItem("delete_team", "§cDelete Team")
        val RENAME_TEAM = emptyItem("rename_team", "§eRename Team")
        val TEAM_PREFIX = emptyItem("team_prefix", "§dChange Prefix")
        val TEAM_SUFFIX = emptyItem("team_suffix", "§dChange Prefix")
        val TEAM_COLOR = emptyItem("team_color", "§7Change Color")
        val TEAM_DISPLAY = emptyItem("team_display", "§bChange Display Name")
        val FFIRE_ENABLED = guiItem("teams/enabled", "§bToggle Friendly Fire", false, 3)
        val FFIRE_ENABLED_EMPTY = emptyItem("friendly_fire_enabled", "§bToggle Friendly Fire")
        val FFIRE_DISABLED = guiItem("teams/disabled", "§bToggle Friendly Fire", false, 3)
        val FFIRE_DISABLED_EMPTY = emptyItem("friendly_fire_disabled", "§bToggle Friendly Fire")

        //Menu Edit Gui Items
        val DELETE_MENU = emptyItem("delete_menu", "§cDelete Menu")
        val VIEW_MENU = emptyItem("view_menu", "§dView Menu")
        val REFRESH_RATE = emptyItem("refresh_rate", "§eSet Refresh Rate")
        val CHANGE_MENU_SIZE = emptyItem("change_size", "§bChange Size")
        val EDIT_MENU_ITEMS = emptyItem("edit_menu_items", "§aEdit Menu Elements")

        //NPC Edit Gui Items
        val DELETE_NPC = emptyItem("delete_npc", "§cDelete NPC")
        val NPC_ACTIONS = emptyItem("npc_actions", "§aClick Actions")
        val NPC_HOLO = emptyItem("npc_hologram", "§bEdit Hologram")
        val NPC_NAME = emptyItem("npc_name", "§eNPC Name")
        val NPC_INFO = emptyItem("npc_info", "§7NPC Info")
        val NPC_SKIN = emptyItem("npc_skin", "§bChange Skin")
        val NPC_TYPE = emptyItem("npc_type", "§dEntity Type")
        val NPC_NAVIGATION = emptyItem("npc_navigation", "§6Navigation")
        val NPC_LOOK_TRUE = guiItem("npcs/look_true", "§bLook at Players")
        val NPC_LOOK_FALSE = guiItem("npcs/look_false", "§bLook at Players")
        val NPC_ARMOR = emptyItem("npc_armor", "§fChange Equipment")
        val NPC_SETTINGS = emptyItem("npc_settings", "§fEntity Settings")

    //Systems > Scoreboard GUI Items
    val TITLE = emptyItem("title", "§bChange Title")
    val NEW_LINE = emptyItem("add_line", "§aAdd Line")

    //Systems > Commands GUI Items
    val CREATE_COMMAND = guiItem("commands/create_command", "§aCreate Command")
    val ADD_ARGUMENT = emptyItem("add_argument", "§aAdd Argument")

    //Systems > Inventory Layouts GUI Items
    val CREATE_LAYOUT = guiItem("layouts/create_layout", "§aCreate Layout")

    //Systems > Teams GUI Items
    val CREATE_TEAM = guiItem("teams/create_team", "§aCreate Team")

    //Systems > Custom Menus GUI Items
    val CREATE_MENU = guiItem("custommenus/create_menu", "§aCreate Menu")
    val MENU_SIZE_SELECTION = emptyItem("menu_size_selection", "§bSelect this size")

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
    val VISIBILITY_WHITELISTED = guiItem("playground.menu/visibility_whitelisted", "§aVisiting Rules", false, 3)
    val VISIBILITY_WHITELISTED_EMPTY = emptyItem("visibility_whitelisted", "§aVisiting Rules")

    //General GUI Items
    val PREVIOUS_PAGE = guiItem("left_arrow", "§aPrevious Page")
    val NEXT_PAGE = guiItem("right_arrow", "§aNext Page")
    val BACK = emptyItem("back", "§eGo Back")
    val SEARCH = emptyItem("search", "§eSearch")
    val NOT_CLICKABLE = emptyItem("not_clickable", "")
    val CLOSE = emptyItem("close", "§cClose")

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