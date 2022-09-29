package io.github.regbl.characters.ui

import com.google.common.truth.Truth.assertThat
import io.github.regbl.characters.MainCoroutineRule
import io.github.regbl.characters.repositories.FakeRandomCharacterRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RandomCharacterViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: RandomCharacterViewModel

    @Before
    fun setUp() {
        viewModel = RandomCharacterViewModel(FakeRandomCharacterRepository())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `randomCharacter is not the same as defaultCharacter`() {
        assertThat(viewModel.randomCharacter.value).isNotEqualTo(RandomCharacterViewModel.defaultCharacterResponse)
    }
}