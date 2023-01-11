package io.github.regbl.characters.ui

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.regbl.characters.other.Event
import io.github.regbl.characters.other.Resource
import io.github.regbl.characters.other.Status
import io.github.regbl.characters.repositories.RandomCharacterRepository
import io.github.regbl.characters.service.responses.Attr
import io.github.regbl.characters.service.responses.CharacterResponse
import io.github.regbl.characters.service.responses.Saves
import io.github.regbl.characters.service.responses.toCharacter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomCharacterViewModel @Inject constructor(
    private val repository: RandomCharacterRepository
) : ViewModel() {
    private val _randomCharacter = MutableLiveData<Event<Resource<CharacterResponse>>>()
    val randomCharacter: LiveData<Event<Resource<CharacterResponse>>> = _randomCharacter

    val staticRandomCharacter = Transformations.map(_randomCharacter) {
        it.peekContent().data?.toCharacter()
    }

    init {
        getRandomCharacter()
    }

    private fun getRandomCharacter() {
        _randomCharacter.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = repository.getRandomCharacter()
            _randomCharacter.postValue(Event(response))
            try {
                _randomCharacter.value = Event(repository.getRandomCharacter())
            } catch (e: Exception) {
                _randomCharacter.value = Event(
                    Resource(
                        Status.ERROR,
                        defaultCharacterResponse,
                        "Unknown error. Here's a default character."
                    )
                )
            }
        }
    }

    companion object {
        val defaultCharacterResponse = CharacterResponse(
            ac = 7,
            appearance = "",
            attr = Attr(
                STR = "13",
                INT = "10",
                WIS = "9",
                DEX = "10",
                CON = "11",
                CHA = "14"
            ),
            attributes = listOf(
                listOf("STR", 13),
                listOf("INT", 10),
                listOf("WIS", 9),
                listOf("DEX", 10),
                listOf("CON", 11),
                listOf("CHA", 14),
            ),
            characterClass = "Fighter",
            equipment = listOf("torches", "rations"),
            hp = 5,
            languages = listOf("common", "alignment"),
            notes = listOf(""),
            personality = "",
            saves = Saves(
                breath = 13,
                magic = 14,
                poison = 15,
                stone = 16,
                wands = 17
            ),
            skills = "",
            spell = listOf(""),
            system = "Basic D&D",
            thac9 = 9,
            toHit = listOf(
                listOf(9, 9),
                listOf(8, 10),
                listOf(7, 11),
                listOf(6, 12),
                listOf(5, 13),
                listOf(4, 14),
                listOf(3, 15),
                listOf(2, 16),
                listOf(1, 17),
                listOf(0, 18)
            )
        )
    }
}