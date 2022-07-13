package io.github.regbl.characters.service

import io.github.regbl.characters.data.model.Character
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface RandomCharacterService {

    @GET("basic/json")
    suspend fun getRandomBasicCharacter(): Character

    companion object {
        private const val BASE_URL = "https://character.totalpartykill.ca/"

        fun create(): RandomCharacterService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RandomCharacterService::class.java)
        }
    }
}