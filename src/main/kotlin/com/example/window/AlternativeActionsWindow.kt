package com.example.window

import com.al3x.housing2.Action.Action
import org.bukkit.entity.Player
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.ItemBuilder
import xyz.xenondevs.invui.window.Window
import xyz.xenondevs.nova.world.item.NovaItem
import java.util.LinkedHashMap

abstract class AlternativeActionsWindow(
    val name: String,
) {
    var action: Action? = null
    val ingredients: HashMap<Gui.Builder<*, *>, ArrayList<Ingredient>> = HashMap()
    val structures: HashMap<Gui.Builder<*, *>, ArrayList<String>> = HashMap()
    var upperGui: Gui.Builder<*, *>? = null
    var lowerGui: Gui.Builder<*, *>? = null

    abstract fun createWindow(): Window.Builder.Normal.Split
    abstract fun createUpperGui(): Gui.Builder<*, *>
    abstract fun createLowerGui(): Gui.Builder<*, *>
    abstract fun getData(): LinkedHashMap<String, Any>

    fun Gui.Builder<*, *>.setStructure(structure: ArrayList<String>): Gui.Builder<*, *> {
        setStructure(*structure.toTypedArray())
        structures[this] = structure

        return this
    }

    fun Gui.Builder<*, *>.addIngredient(char: Char, item: ItemBuilder, slot: Int): Gui.Builder<*, *> {
        addIngredient(char, item)

        if (!ingredients.containsKey(this)) {
            ingredients[this] = ArrayList()
        }

        ingredients[this]!!.add(Ingredient(char, item, slot))

        return this
    }

    class Ingredient(val char: Char, val item: ItemBuilder, val slot: Int)
}