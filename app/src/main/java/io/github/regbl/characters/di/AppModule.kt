package io.github.regbl.characters.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.regbl.characters.data.CharacterDao
import io.github.regbl.characters.data.CharacterDatabase
import io.github.regbl.characters.repositories.DefaultRandomCharacterRepository
import io.github.regbl.characters.repositories.RandomCharacterRepository
import io.github.regbl.characters.service.RandomCharacterService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideCharacterDatabase(@ApplicationContext appContext: Context): CharacterDatabase =
        Room.databaseBuilder(
            appContext.applicationContext,
            CharacterDatabase::class.java,
            "character_database"
        ).build()

    @Provides
    fun provideCharacterDao(characterDB: CharacterDatabase): CharacterDao =
        characterDB.characterDao()

    @Singleton
    @Provides
    fun provideDefaultRandomCharacterRepository(
        service: RandomCharacterService,
        dao: CharacterDao
    ): RandomCharacterRepository {
        return DefaultRandomCharacterRepository(service, dao)
    }
}