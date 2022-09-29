package io.github.regbl.characters.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.regbl.characters.repositories.DefaultRandomCharacterRepository
import io.github.regbl.characters.repositories.RandomCharacterRepository
import io.github.regbl.characters.service.RandomCharacterService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideDefaultRandomCharacterRepository(service: RandomCharacterService) =
        DefaultRandomCharacterRepository(service) as RandomCharacterRepository
}