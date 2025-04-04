package com.example.guitextures

import com.example.ExampleAddon
import xyz.xenondevs.nova.addon.registry.GuiTextureRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage

@Init(stage = InitStage.PRE_PACK)
object GuiTextures : GuiTextureRegistry by ExampleAddon.registry {
    //Browser
    val PLAYGROUND_BROWSER_WINDOW = guiTexture("browser_window") {
        alignment(-25,-21)
        path("gui/browser_window")
    }
    val MY_CREATIONS_WINDOW = guiTexture("my_creations_window") {
        alignment(-25,-21)
        path("gui/my_creations_window")
    }
        //Edit Creation
        val EDIT_CREATION_WINDOW = guiTexture("edit_creation_window") {
            alignment(-25,-21)
            path("gui/edit_creation_window")
        }
        //Confirmation
            val CONFIRMATION_WINDOW = guiTexture("confirmation_window") {
            alignment(-25,-21)
            path("gui/confirmation_window")
        }
    //Actions
    val CONDITIONALS = guiTexture("actions/conditionals") {
         alignment(-25,-21)
         path("gui/actions/conditionals")
    }
    val CHAT_ACTION_SETTINGS = guiTexture("actions/chat_action_settings") {
        alignment(-25,-21)
        path("gui/actions/chat_action_settings")
    }
    //Options for Actions
    val TELEPORT_OPTIONS = guiTexture("actions/options/teleport_options") {
        alignment(-25,-21)
        path("gui/actions/options/teleport_options")
    }
    val GENERIC_OPTIONS = guiTexture("actions/options/generic_options") {
        alignment(-25,-21)
        path("gui/actions/options/generic_options")
    }

    //Edit Item
    val EDIT_ITEM_WINDOW = guiTexture("edit_item_window") {
        alignment(-26,-21)
        path("gui/edit_item_window")
    }

    //Select Item
    val SELECT_ITEM_WINDOW = guiTexture("select_item_window") {
        alignment(-25,-21)
        path("gui/select_item_window")
    }

    //Generic
    val ACTIONS_WINDOW = guiTexture("actions_window") {
        alignment(-25,-21)
        path("gui/actions_window")
    }

    val ADD_ACTIONS_WINDOW = guiTexture("add_actions_window") {
        alignment(-25,-21)
        path("gui/add_actions_window")
    }
    //Systems
    val FUNCTIONS_WINDOW = guiTexture("functions_window") {
        alignment(-25,-21)
        path("gui/functions_window")
    }
    val REGIONS_WINDOW = guiTexture("regions_window") {
        alignment(-25,-21)
        path("gui/regions_window")
    }
        // Edit Region window
        val EDIT_REGION_WINDOW = guiTexture("edit_region_window") {
            alignment(-25,-21)
            path("gui/edit_region_window")
        }
        // Edit Region window
        val EDIT_COMMAND_WINDOW = guiTexture("edit_command_window") {
            alignment(-25,-21)
            path("gui/edit_command_window")
        }
        // Edit Function window
        val EDIT_FUNCTION_WINDOW = guiTexture("edit_function_window") {
            alignment(-25,-21)
            path("gui/edit_function_window")
        }

    val EVENTACTIONS_WINDOW = guiTexture("eventactions_window") {
        alignment(-25,-21)
        path("gui/eventactions_window")
    }
    val SCOREBOARD_WINDOW = guiTexture("scoreboard_window") {
        alignment(-25, -21)
        path("gui/scoreboard_window")
    }
    val COMMANDS_WINDOW = guiTexture("commands_window") {
        alignment(-25, -21)
        path("gui/commands_window")
    }
    val LAYOUTS_WINDOW = guiTexture("layouts_window") {
        alignment(-25, -21)
        path("gui/layouts_window")
    }
    val TEAMS_WINDOW = guiTexture("teams_window") {
        alignment(-25, -21)
        path("gui/teams_window")
    }
    val CUSTOM_MENUS_WINDOW = guiTexture("custom_menus_window") {
        alignment(-25, -21)
        path("gui/custom_menus_window")
    }
    val NPCS_WINDOW = guiTexture("npcs_window") {
        alignment(-25, -21)
        path("gui/npcs_window")
    }
    val SYSTEMS_WINDOW = guiTexture("systems_window") {
        alignment(-25, -21)
        path("gui/systems_window")
    }
    val PLAYGROUND_WINDOW = guiTexture("playground_window") {
        alignment(-25,-21)
        path("gui/playground_window")
    }


    val TEMPLATE = guiTexture("template") {
        alignment(-25,-21)
        path("gui/template")
    }

}