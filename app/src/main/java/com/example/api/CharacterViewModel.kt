package com.example.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class CharactersViewModel(private val repository: CharactersRepository) : ViewModel() {

    private val _character = MutableLiveData<Character>()

    val character: LiveData<Character> = _character


    fun getCharacterById(id: Int) {

        viewModelScope.launch {

            val character = repository.getCharacterById(id)

            _character.value = character

        }

    }


    fun toggleFavourite(character: Character) {

        // Add or remove character from favourite characters list

    }


    fun isFavourite(characterId: Int) = favouriteCharacters.value?.any { it.id == characterId } == true

}