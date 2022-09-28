package io.github.regbl.characters.repositories

import io.github.regbl.characters.other.Resource
import io.github.regbl.characters.service.responses.CharacterResponse

interface RandomCharacterRepository {
    suspend fun getRandomCharacter(): Resource<CharacterResponse>
}