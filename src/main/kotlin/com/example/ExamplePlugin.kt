package com.example

import com.example.customitems.NeighborhoodItems
import com.example.listeners.OpenActionMenuListener
import com.example.listeners.OpenMenuListener
import com.example.window.AlternativeActionsWindow
import com.example.window.AlternativeWindow
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class ExamplePlugin : JavaPlugin() {
    companion object {
        var actionsWindow = HashMap<UUID, AlternativeActionsWindow>()
        var windows = HashMap<UUID, AlternativeWindow>()
        lateinit var INSTANCE: ExamplePlugin
    }

    override fun onEnable() {
        this.logger.info("Example plugin loaded!")
        if (server.pluginManager.isPluginEnabled("Housing2")) {
            server.pluginManager.registerEvents(OpenActionMenuListener(), this)
            server.pluginManager.registerEvents(OpenMenuListener(), this)
        }

        INSTANCE = this
    }

    fun neighborhoodItems(): ArrayList<ItemStack> {
        return ArrayList(NeighborhoodItems.values())
    }
}