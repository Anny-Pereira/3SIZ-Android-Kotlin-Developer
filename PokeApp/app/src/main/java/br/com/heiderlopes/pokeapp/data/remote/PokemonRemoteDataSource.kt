package br.com.heiderlopes.pokeapp.data.remote

import br.com.heiderlopes.pokeapp.data.model.PokemonResponse

// Manter o package

interface PokemonRemoteDataSource {
    suspend fun getPokemonByNumber(number: Int): PokemonResponse
}