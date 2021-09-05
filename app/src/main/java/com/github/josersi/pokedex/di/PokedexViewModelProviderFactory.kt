package com.github.josersi.pokedex.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.josersi.pokedex.PokedexViewModel
import com.github.josersi.pokedex.domain.data.PokedexRemoteDataSource
import com.github.josersi.pokedex.domain.model.PokedexRepository
import com.github.josersi.pokedex.network.PokedexApi

class PokedexViewModelProviderFactory : ViewModelProvider.Factory {

    private val pokedexRepository = PokedexRepository(PokedexRemoteDataSource(PokedexApi.instance))

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokedexViewModel(pokedexRepository) as T
    }
}