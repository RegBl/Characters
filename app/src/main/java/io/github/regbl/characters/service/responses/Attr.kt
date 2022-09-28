package io.github.regbl.characters.service.responses

import io.github.regbl.characters.data.model.Attributes

data class Attr(
    val CHA: String,
    val CON: String,
    val DEX: String,
    val INT: String,
    val STR: String,
    val WIS: String
)

fun Attr.toAttributes(): Attributes {
    return Attributes(
        strength = STR.toInt(),
        dexterity = DEX.toInt(),
        constitution = CON.toInt(),
        intelligence = INT.toInt(),
        wisdom = WIS.toInt(),
        charisma = CHA.toInt()
    )
}