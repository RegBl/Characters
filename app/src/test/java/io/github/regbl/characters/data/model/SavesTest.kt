package io.github.regbl.characters.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class SavesTest {

    private val saves = Saves(
        wands = 13,
        breath = 15,
        stone = 14,
        magic = 16,
        poison = 12
    )

    @Test
    fun `saves wands is equal to 13`() {
        assertThat(saves.wands).isEqualTo(13)
    }
}