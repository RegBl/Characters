package io.github.regbl.characters.data.model

data class Character(
    val attributes: Attributes,
    val saves: Saves,
    val characterClass: String,
    val level: Int,
    val ac: Int,
    val hp: Int,
    val xp: Int,
    val system: String
)
