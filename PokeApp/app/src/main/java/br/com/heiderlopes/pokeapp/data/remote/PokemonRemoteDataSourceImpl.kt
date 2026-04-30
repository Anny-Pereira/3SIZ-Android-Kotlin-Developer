package br.com.heiderlopes.pokeapp.data.remote

import br.com.heiderlopes.pokeapp.data.model.PokemonResponse

class PokemonRemoteDataSourceImpl(
    private val api: PokemonApi
) : PokemonRemoteDataSource {

    override suspend fun getPokemonByNumber(number: Int): PokemonResponse {
        return api.getPokemonByNumber(number)
    }
}