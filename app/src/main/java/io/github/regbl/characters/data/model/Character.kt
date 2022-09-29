package io.github.regbl.characters.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val attributes: Attributes,
    val saves: Saves,
    val characterClass: String,
    val level: Int,
    val ac: Int,
    val hp: Int,
    val xp: Int,
    val system: String
)
