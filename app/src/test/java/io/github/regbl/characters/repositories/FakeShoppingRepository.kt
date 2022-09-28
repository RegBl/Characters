package io.github.regbl.characters.repositories

import io.github.regbl.characters.other.Resource
import io.github.regbl.characters.service.responses.Attr
import io.github.regbl.characters.service.responses.CharacterResponse
import io.github.regbl.characters.service.responses.Saves

class FakeShoppingRepository : RandomCharacterRepository {
    private val randomCharacter = CharacterResponse(
        ac = 7,
        appearance = "",
        attr = Attr(
            STR = "13",
            INT = "10",
            WIS = "9",
            DEX = "10",
            CON = "11",
            CHA = "14"
        ),
        attributes = listOf(
            listOf("STR", 13),
            listOf("INT", 10),
            listOf("WIS", 9),
            listOf("DEX", 10),
            listOf("CON", 11),
            listOf("CHA", 14),
        ),
        characterClass = "Fighter",
        equipment = listOf("torches", "rations"),
        hp = 5,
        languages = listOf("common", "alignment"),
        notes = listOf(""),
        personality = "",
        saves = Saves(
            breath = 13,
            magic = 14,
            poison = 15,
            stone = 16,
            wands = 17
        ),
        skills = "",
        spell = listOf(""),
        system = "Basic D&D",
        thac9 = 9,
        toHit = listOf(
            listOf(9, 9),
            listOf(8, 10),
            listOf(7, 11),
            listOf(6, 12),
            listOf(5, 13),
            listOf(4, 14),
            listOf(3, 15),
            listOf(2, 16),
            listOf(1, 17),
            listOf(0, 18)
        )
    )

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getRandomCharacter(): Resource<CharacterResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error("Error", null)
        } else {
            Resource.success(randomCharacter)
        }
    }
}