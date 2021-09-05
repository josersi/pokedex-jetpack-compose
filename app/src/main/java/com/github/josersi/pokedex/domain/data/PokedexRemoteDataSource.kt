package com.github.josersi.pokedex.domain.data

import com.github.josersi.pokedex.network.PokedexApi

class PokedexRemoteDataSource(private val pokedexApi: PokedexApi) {

    suspend fun getPokemons() = pokedexApi.getPokemons()
}