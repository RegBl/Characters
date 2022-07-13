package io.github.regbl.characters.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AttributesTest {

    private val attributes = Attributes(
        strength = 10,
        dexterity = 10,
        constitution = 10,
        intelligence = 10,
        wisdom = 10,
        charisma = 10
    )

    @Test
    fun `attributes strength matches new attributes strength`() {
        assertThat(attributes.strength).isEqualTo(10)
    }
}