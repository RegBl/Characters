package io.github.regbl.characters.service

import io.github.regbl.characters.service.responses.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface RandomCharacterService {

    @GET("basic/json")
    suspend fun getRandomBasicCharacter(): Response<CharacterResponse>
}