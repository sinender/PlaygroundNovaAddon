package com.example.guitextures

import com.example.ExampleAddon
import xyz.xenondevs.nova.addon.registry.GuiTextureRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage

@Init(stage = InitStage.PRE_PACK)
object GuiTextures : GuiTextureRegistry by ExampleAddon.registry {

    val CONDITIONALS = guiTexture("conditionals") {
         alignment(-25,-21)
         path("gui/conditionals")
    }

}