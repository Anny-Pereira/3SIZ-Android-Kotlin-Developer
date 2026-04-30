package br.com.heiderlopes.pokeapp.di

import br.com.heiderlopes.pokeapp.data.remote.PokemonRemoteDataSource
import br.com.heiderlopes.pokeapp.data.remote.PokemonRemoteDataSourceImpl
import br.com.heiderlopes.pokeapp.data.repository.PokemonRepositoryImpl
import br.com.heiderlopes.pokeapp.domain.repository.PokemonRepository
import org.koin.dsl.module

val dataModule = module {

    single<PokemonRemoteDataSource> {
        PokemonRemoteDataSourceImpl(api = get())
    }

    single<PokemonRepository> {
        PokemonRepositoryImpl(remoteDataSource = get())
    }
}