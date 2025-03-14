package com.example.guitextures

import com.example.ExampleAddon
import xyz.xenondevs.nova.addon.registry.GuiTextureRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage

@Init(stage = InitStage.PRE_PACK)
object GuiTextures : GuiTextureRegistry by ExampleAddon.registry {

    //Actions
    val CONDITIONALS = guiTexture("actions/conditionals") {
         alignment(-25,-21)
         path("gui/actions/conditionals")
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