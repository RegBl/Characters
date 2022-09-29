package io.github.regbl.characters.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.regbl.characters.data.model.Character
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: Character)

    @Query("SELECT * FROM character WHERE id = :characterId")
    fun getCharacter(characterId: Int): Flow<Character>

    @Delete
    suspend fun deleteCharacter(character: Character)
}