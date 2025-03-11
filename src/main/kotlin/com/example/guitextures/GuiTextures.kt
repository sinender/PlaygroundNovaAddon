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

}