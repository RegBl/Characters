package io.github.regbl.characters.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.regbl.characters.service.RandomCharacterService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRandomCharacterService(): RandomCharacterService {
        return RandomCharacterService.create()
    }
}