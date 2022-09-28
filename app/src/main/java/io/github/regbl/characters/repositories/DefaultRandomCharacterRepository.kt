package io.github.regbl.characters.repositories

import io.github.regbl.characters.other.Resource
import io.github.regbl.characters.service.RandomCharacterService
import io.github.regbl.characters.service.responses.CharacterResponse
import javax.inject.Inject

class DefaultRandomCharacterRepository @Inject constructor(private val service: RandomCharacterService) :
    RandomCharacterRepository {
    override suspend fun getRandomCharacter(): Resource<CharacterResponse> {
        return try {
            val response = service.getRandomBasicCharacter()
            if (response.isSuccessful) response.body()?.let {
                return@let Resource.success(it)
            } ?: Resource.error("An unknown error occurred.", null) else {
                return Resource.error("An unknown error occurred.", null)
            }
        } catch (e: Exception) {
            Resource.error("Couldn't reach the server. Check your internet connection.", null)
        }
    }

}