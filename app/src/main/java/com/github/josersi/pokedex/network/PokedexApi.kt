package com.github.josersi.pokedex.network

import com.github.josersi.pokedex.domain.data.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokedexApi {

    @GET(".")
    suspend fun getPokemons(): List<Pokemon>

    companion object {
        val instance: PokedexApi by lazy {
            retrofit.create(PokedexApi::class.java)
        }
    }
}

