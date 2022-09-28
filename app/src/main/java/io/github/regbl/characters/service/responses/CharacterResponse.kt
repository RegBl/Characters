package io.github.regbl.characters.service.responses

import com.google.gson.annotations.SerializedName
import io.github.regbl.characters.data.model.Character

data class CharacterResponse(
    val ac: Int,
    val appearance: String,
    val attr: Attr,
    // attributes [String, Int]
    val attributes: List<List<Any>>,
    @SerializedName("class")
    val characterClass: String,
    val equipment: List<String>,
    val hp: Int,
    val languages: List<String>,
    val notes: List<String>,
    val personality: String,
    val saves: Saves,
    val skills: Any,
    val spell: List<String>,
    val system: String,
    val thac9: Int,
    @SerializedName("to_hit")
    // attributes [Int, Int]
    val toHit: List<List<Int>>
)

fun CharacterResponse.toCharacter(): Character {
    return Character(
        attributes = this.attr.toAttributes(),
        saves = this.saves.toSaves(),
        characterClass = this.characterClass,
        level = 1,
        ac = this.ac,
        hp = this.hp,
        xp = 0,
        system = this.system
    )
}