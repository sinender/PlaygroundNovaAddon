package com.example.guitextures

import com.example.ExampleAddon
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import org.joml.Vector3d
import org.joml.Vector3f
import xyz.xenondevs.nova.addon.registry.ItemRegistry
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.initialize.InitStage
import xyz.xenondevs.nova.resources.builder.model.Model
import xyz.xenondevs.nova.world.item.NovaItem
import xyz.xenondevs.nova.world.item.behavior.ItemBehaviorHolder


@Init(stage = InitStage.PRE_PACK)
object GuiItems : ItemRegistry by ExampleAddon.registry {
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
    val EXPORT_ACTION = guiItem("action/export", "§aExport Actions")
    val IMPORT_ACTION = guiItem("action/import", "§bImport Actions")
    val IMPORT_AUTO = guiItem("action/import_auto", "§bImport Actions from Websocket")
    val NO_ACTION = guiItem("action/no_action", "§cNo Actions!", false, 3)
    val NO_ACTION_EMPTY = emptyItem("no_action", "§cNo Actions!")
    val RESTORE = guiItem("action/restore", "§aRestore")

    //Systems > Functions GUI Items
    val ADD_FUNCTION = guiItem("functions/add_function", "§aAdd Function")
    val NO_ITEMS = guiItem("functions/no_items", "§aNo Items!", false, 3)
    val NO_ITEMS_EMPTY = emptyItem("no_items", "§aNo Items!")

    //General GUI Items
    val PREVIOUS_PAGE = guiItem("left_arrow", "§aPrevious Page")
    val NEXT_PAGE = guiItem("right_arrow", "§aNext Page")
    val BACK = emptyItem("back", "§cGo Back")
    val SEARCH = emptyItem("search", "§eSearch")

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
                scale = Vector3d(3.0, 1.0, 1.0),
                translation = Vector3d(16.0, 0.0, 0.0)
            )
            else -> Model.Display(
                scale = Vector3d(1.0, 1.0, 1.0),
                translation = Vector3d(0.0, 0.0, 0.0)
            )
        }

        modelDefinition {
            model = buildModel { createGuiModel(false, stretched, "item/gui/$name",
                display = display
            ) }
        }
    }
}