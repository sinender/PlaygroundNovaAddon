package com.example.guitextures

import com.example.ExampleAddon
import xyz.xenondevs.nova.addon.registry.GuiTextureRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage

@Init(stage = InitStage.PRE_PACK)
object GuiTextures : GuiTextureRegistry by ExampleAddon.registry {
    //Browser
    val PLAYGROUND_BROWSER_WINDOW = guiTexture("browser_window") {
        alignment(-26,-21)
        path("gui/browser_window")
    }
    val MY_CREATIONS_WINDOW = guiTexture("my_creations_window") {
        alignment(-26,-21)
        path("gui/my_creations_window")
    }
    //Edit Creation
    val EDIT_CREATION_WINDOW = guiTexture("edit_creation_window") {
        alignment(-26,-21)
        path("gui/edit_creation_window")
    }
    //Confirmation
    val CONFIRMATION_WINDOW = guiTexture("confirmation_window") {
        alignment(-26,-21)
        path("gui/confirmation_window")
    }
    //Actions
    val CONDITIONALS = guiTexture("actions/conditionals") {
        alignment(-26,-21)
        path("gui/actions/conditionals")
    }
    val CHAT_ACTION_SETTINGS = guiTexture("actions/chat_action_settings") {
        alignment(-26,-21)
        path("gui/actions/chat_action_settings")
    }
    //Options for Actions
    val TELEPORT_OPTIONS = guiTexture("actions/options/teleport_options") {
        alignment(-26,-21)
        path("gui/actions/options/teleport_options")
    }
    val GENERIC_OPTIONS = guiTexture("actions/options/generic_options") {
        alignment(-26,-21)
        path("gui/actions/options/generic_options")
    }

    //Edit Item
    val EDIT_ITEM_WINDOW = guiTexture("edit_item_window") {
        alignment(-26,-21)
        path("gui/edit_item_window")
    }

    //Select Item
    val SELECT_ITEM_WINDOW = guiTexture("select_item_window") {
        alignment(-26,-21)
        path("gui/select_item_window")
    }

    //Generic
    val ACTIONS_WINDOW = guiTexture("actions_window") {
        alignment(-26,-21)
        path("gui/actions_window")
    }

    val ADD_ACTIONS_WINDOW = guiTexture("add_actions_window") {
        alignment(-26,-21)
        path("gui/add_actions_window")
    }

    val ACTION_CLIPBOARD_WINDOW = guiTexture("action_clipboard_window") {
        alignment(-26,-21)
        path("gui/action_clipboard_window")
    }
    //Groups
    val GROUPS_WINDOW = guiTexture("groups_window") {
        alignment(-26,-21)
        path("gui/groups_window")
    }
    val GROUP_PERMISSIONS_WINDOW = guiTexture("group_permissions_window") {
        alignment(-26,-21)
        path("gui/edit_group_permissions_window")
    }
    //Group Edits
    val EDIT_GROUP_WINDOW = guiTexture("edit_group_window") {
        alignment(-26,-21)
        path("gui/group.edits/edit_group")
    }
    val EDIT_GROUP_A_WINDOW = guiTexture("edit_group_a_window") {
        alignment(-26,-21)
        path("gui/group.edits/edit_group_a")
    }
    val EDIT_GROUP_B_WINDOW = guiTexture("edit_group_b_window") {
        alignment(-26,-21)
        path("gui/group.edits/edit_group_b")
    }
    val EDIT_GROUP_AB_WINDOW = guiTexture("edit_group_ab_window") {
        alignment(-26,-21)
        path("gui/group.edits/edit_group_ab")
    }
    //Systems
    val FUNCTIONS_WINDOW = guiTexture("functions_window") {
        alignment(-26,-21)
        path("gui/functions_window")
    }
    val REGIONS_WINDOW = guiTexture("regions_window") {
        alignment(-26,-21)
        path("gui/regions_window")
    }
    // Edit Region window
    val EDIT_REGION_WINDOW = guiTexture("edit_region_window") {
        alignment(-26,-21)
        path("gui/edit_region_window")
    }
    // Edit Command window
    val EDIT_COMMAND_WINDOW = guiTexture("edit_command_window") {
        alignment(-26,-21)
        path("gui/edit_command_window")
    }
    // Edit Function window
    val EDIT_FUNCTION_WINDOW = guiTexture("edit_function_window") {
        alignment(-26,-21)
        path("gui/edit_function_window")
    }
    // Edit Layout window
    val EDIT_LAYOUT_WINDOW = guiTexture("edit_layout_window") {
        alignment(-26,-21)
        path("gui/edit_layout_window")
    }
    // Edit Team window
    val EDIT_TEAM_WINDOW = guiTexture("edit_team_window") {
        alignment(-26,-21)
        path("gui/edit_team_window")
    }
    // Edit Menu window
    val EDIT_MENU_WINDOW = guiTexture("edit_menu_window") {
        alignment(-26,-21)
        path("gui/edit_menu_window")
    }
    // Menu Sizes
    val MENU_1 = guiTexture("menu_1") {
        alignment(-26,-21)
        path("gui/menu.sizes/menu_size_1")
    }
    val MENU_2 = guiTexture("menu_2") {
        alignment(-26,-21)
        path("gui/menu.sizes/menu_size_2")
    }
    val MENU_3 = guiTexture("menu_3") {
        alignment(-26,-21)
        path("gui/menu.sizes/menu_size_3")
    }
    val MENU_4 = guiTexture("menu_4") {
        alignment(-26,-21)
        path("gui/menu.sizes/menu_size_4")
    }
    val MENU_5 = guiTexture("menu_5") {
        alignment(-26,-21)
        path("gui/menu.sizes/menu_size_5")
    }
    val MENU_6 = guiTexture("menu_6") {
        alignment(-26,-21)
        path("gui/menu.sizes/menu_size_6")
    }
    // Edit Npc window
    val EDIT_NPC_WINDOW = guiTexture("edit_npc_window") {
        alignment(-26,-21)
        path("gui/edit_npc_window")
    }

    val EVENTACTIONS_WINDOW = guiTexture("eventactions_window") {
        alignment(-26,-21)
        path("gui/eventactions_window")
    }
    val SCOREBOARD_WINDOW = guiTexture("scoreboard_window") {
        alignment(-26, -21)
        path("gui/scoreboard_window")
    }
    val COMMANDS_WINDOW = guiTexture("commands_window") {
        alignment(-26, -21)
        path("gui/commands_window")
    }
    val EDIT_ARGS_WINDOW = guiTexture("edit_arguments_window") {
        alignment(-26, -21)
        path("gui/edit_arguments_window")
    }
    val LAYOUTS_WINDOW = guiTexture("layouts_window") {
        alignment(-26, -21)
        path("gui/layouts_window")
    }
    val TEAMS_WINDOW = guiTexture("teams_window") {
        alignment(-26, -21)
        path("gui/teams_window")
    }
    val CUSTOM_MENUS_WINDOW = guiTexture("custom_menus_window") {
        alignment(-26, -21)
        path("gui/custom_menus_window")
    }
    val NPCS_WINDOW = guiTexture("npcs_window") {
        alignment(-26, -21)
        path("gui/npcs_window")
    }
    val SYSTEMS_WINDOW = guiTexture("systems_window") {
        alignment(-26, -21)
        path("gui/systems_window")
    }
    val PLAYGROUND_WINDOW = guiTexture("playground_window") {
        alignment(-26,-21)
        path("gui/playground_window")
    }


    val TEMPLATE = guiTexture("template") {
        alignment(-26,-21)
        path("gui/template")
    }

}