package com.example

import com.al3x.housing2.Instances.HousingWorld
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.entity.Player

//Copied from Hysentials

fun CharSequence.startsWithAny(sequences: Iterable<CharSequence>): Boolean = sequences.any { contains(it) }
fun CharSequence?.containsAny(vararg sequences: CharSequence?): Boolean {
    if (this == null) return false
    return sequences.any { it != null && this.contains(it) }
}

//shift a list of strings to the right and return the String
fun List<String>.shiftRight(): String {
    val last = this.last()
    val list = this.dropLast(1)
    return last + list.joinToString("")
}

fun String.substringBefore(delimiter: String): String {
    return this.substringBefore(delimiter, this)
}

fun String.substringAfter(delimiter: String): String {
    return this.substringAfter(delimiter, this)
}



fun String.toTitleCase(): String = this.lowercase().replaceFirstChar { c -> c.titlecase() }
fun String.splitToWords(): String = this.split('_', ' ').joinToString(" ") { it.toTitleCase() }
fun String.isInteger(): Boolean = this.toIntOrNull() != null
fun String.formatCapitalize(): String = this.replace("_", " ").split(" ").joinToString(" ") { it.toTitleCase() }