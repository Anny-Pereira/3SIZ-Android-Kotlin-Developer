package br.com.heiderlopes.pokeapp.di

import br.com.heiderlopes.pokeapp.presentation.pokemon.detail.PokemonDetailViewModel
import br.com.heiderlopes.pokeapp.presentation.pokemon.search.PokemonSearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        PokemonSearchViewModel()
    }

    viewModel {
        PokemonDetailViewModel(get())
    }

}
