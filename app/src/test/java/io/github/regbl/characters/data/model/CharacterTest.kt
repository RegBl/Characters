package io.github.regbl.characters.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CharacterTest {

    private val saves = Saves(
        wands = 13,
        breath = 15,
        stone = 14,
        magic = 16,
        poison = 12
    )

    private val attributes = Attributes(
        strength = 10,
        dexterity = 10,
        constitution = 10,
        intelligence = 10,
        wisdom = 10,
        charisma = 10
    )

    private val character = Character(
        attributes,
        saves,
        "Fighter",
        1,
        9,
        4,
        0,
        "Basic D&D"
    )

    @Test
    fun `character attributes strength equals 10`() {
        assertThat(character.attributes.strength).isEqualTo(10)
    }

    @Test
    fun `character saves wands equals 13`() {
        assertThat(character.saves.wands).isEqualTo(13)
    }

    @Test
    fun `character system equals Basic D&D`() {
        assertThat(character.system).isEqualTo("Basic D&D")
    }
}