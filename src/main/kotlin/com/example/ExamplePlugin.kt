package com.example

import com.al3x.housing2.Action.Actions.ConditionalAction
import com.example.guitextures.GuiItems
import com.example.guitextures.GuiTextures
import com.example.listeners.OpenActionMenuListener
import com.example.window.AlternativeActionsWindow
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.window.Window
import java.util.UUID

class ExamplePlugin : JavaPlugin() {
    companion object {
        var actionsWindow = HashMap<UUID, AlternativeActionsWindow>()
    }
    override fun onEnable() {
        this.logger.info("Example plugin loaded!")
        if (server.pluginManager.isPluginEnabled("Housing2")) {
            server.pluginManager.registerEvents(OpenActionMenuListener(), this)
        }
    }
}