package io.github.regbl.characters.data

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.regbl.characters.data.model.Attributes
import io.github.regbl.characters.data.model.Character
import io.github.regbl.characters.data.model.Saves

@Database(
    entities = [
        Character::class,
        Attributes::class,
        Saves::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}