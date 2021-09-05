package com.github.josersi.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign
import com.github.josersi.pokedex.di.PokedexViewModelProviderFactory
import com.github.josersi.pokedex.domain.data.Pokemon
import com.github.josersi.pokedex.network.Resource
import com.github.josersi.pokedex.ui.theme.PokedexTheme


class MainActivity : ComponentActivity() {

    private val viewModel: PokedexViewModel by viewModels { PokedexViewModelProviderFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val posters: Resource<List<Pokemon>> by viewModel.pokemons.observeAsState(Resource.Loading())

                    when(posters) {
                        is Resource.Loading -> CircularProgressIndicator()
                        is Resource.Success -> posters.data?.let { Posters(it) }
                        is Resource.Error -> Text(text = "Error loading: ${(posters as Resource.Error<List<Pokemon>>).message}")
                    }
                }
            }
        }
    }
}

@Composable
fun Posters(pokemons: List<Pokemon>) {

    LazyColumn  {
        items(pokemons.size) { index ->
            Text(
                text = "${pokemons[index].name}",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
            )
        }
    }
}