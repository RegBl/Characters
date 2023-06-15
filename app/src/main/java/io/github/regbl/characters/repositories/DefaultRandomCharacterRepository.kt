package io.github.regbl.characters.repositories

import io.github.regbl.characters.data.CharacterDao
import io.github.regbl.characters.data.model.Character
import io.github.regbl.characters.other.Resource
import io.github.regbl.characters.service.RandomCharacterService
import io.github.regbl.characters.service.responses.CharacterResponse
import io.github.regbl.characters.service.responses.toCharacter
import javax.inject.Inject

class DefaultRandomCharacterRepository @Inject constructor(
    private val service: RandomCharacterService,
    private val dao: CharacterDao
) : RandomCharacterRepository {
    override suspend fun getRandomCharacter(): Resource<Character> {
        return try {
            val response = service.getRandomBasicCharacter()
            if (response.isSuccessful) response.body()?.let {
                dao.insertCharacter(it.toCharacter())
                return@let Resource.success(dao.getLatestCharacter())
            } ?: Resource.error("An unknown error occurred.", null) else {
                return Resource.error("An unknown error occurred.", null)
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check your internet connection.", null)
        }
    }
}