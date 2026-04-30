package br.com.heiderlopes.pokeapp.data.repository

import br.com.heiderlopes.pokeapp.data.model.toDomain
import br.com.heiderlopes.pokeapp.data.remote.PokemonRemoteDataSource
import br.com.heiderlopes.pokeapp.domain.common.Resource
import br.com.heiderlopes.pokeapp.domain.model.Pokemon
import br.com.heiderlopes.pokeapp.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override suspend fun getPokemonByNumber(number: Int): Resource<Pokemon> {
        return try {
            val response = remoteDataSource.getPokemonByNumber(number)
            Resource.Success(response.toDomain())
        } catch (exception: Exception) {
            Resource.Error("Não foi possível buscar o Pokémon.")
        }
    }
}