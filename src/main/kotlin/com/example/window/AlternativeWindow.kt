package com.example.window

import com.al3x.housing2.Menus.Menu
import org.bukkit.entity.Player
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.gui.Structure
import xyz.xenondevs.invui.item.ItemBuilder
import xyz.xenondevs.invui.window.AbstractSplitWindow
import xyz.xenondevs.invui.window.Window
import java.util.LinkedHashMap

abstract class AlternativeWindow {
    var window: Window.Builder.Normal.Split? = null
    var menu: Menu? = null
    val ingredients: HashMap<Gui.Builder<*, *>, ArrayList<Ingredient>> = HashMap()
    val structures: HashMap<Gui.Builder<*, *>, ArrayList<String>> = HashMap()
    var upperGui: Gui.Builder<*, *>? = null
    var lowerGui: Gui.Builder<*, *>? = null

    abstract fun createWindow(): Window.Builder.Normal.Split
    abstract fun createUpperGui(): Gui.Builder<*, *>
    abstract fun createLowerGui(): Gui.Builder<*, *>

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

fun Gui.Builder<*, *>.getStructure(): Structure? {
    try {
        var field = this.javaClass.superclass.getDeclaredField("structure")
        field.isAccessible = true
        return field.get(this) as Structure
    } catch (e: NoSuchFieldException) {
        e.printStackTrace()
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
    }
    return null
}

fun Structure.getAsString(): String? {
    try {
        var field = this.javaClass.getDeclaredField("structureData")
        field.isAccessible = true
        return field.get(this) as String
    } catch (e: NoSuchFieldException) {
        e.printStackTrace()
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
    }
    return null
}