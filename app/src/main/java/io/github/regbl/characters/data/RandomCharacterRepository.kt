package io.github.regbl.characters.data

import io.github.regbl.characters.service.RandomCharacterService
import javax.inject.Inject

class RandomCharacterRepository @Inject constructor(private val service: RandomCharacterService) {
    suspend fun getRandomCharacter() = service.getRandomBasicCharacter()
}