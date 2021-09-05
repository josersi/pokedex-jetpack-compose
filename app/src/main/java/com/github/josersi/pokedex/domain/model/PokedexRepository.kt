package com.github.josersi.pokedex.domain.model

import com.github.josersi.pokedex.domain.data.PokedexRemoteDataSource
import com.github.josersi.pokedex.domain.data.Pokemon
import com.github.josersi.pokedex.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokedexRepository(private val pokedexRemoteDataSource: PokedexRemoteDataSource) {

    fun getPokemons() = flow<Resource<List<Pokemon>>> {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(pokedexRemoteDataSource.getPokemons()))
        } catch (ex: Exception) {
            emit(Resource.Error(ex.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
}