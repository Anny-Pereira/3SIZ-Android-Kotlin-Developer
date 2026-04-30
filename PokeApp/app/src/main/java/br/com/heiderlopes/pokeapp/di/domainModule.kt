package br.com.heiderlopes.pokeapp.di

import br.com.heiderlopes.pokeapp.domain.usecase.GetPokemonByNumberUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetPokemonByNumberUseCase(repository = get())
    }
}