package com.github.josersi.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.josersi.pokedex.domain.model.PokedexRepository

class PokedexViewModel(private val pokedexRepository: PokedexRepository): ViewModel() {

    val pokemons = pokedexRepository.getPokemons().asLiveData()
}