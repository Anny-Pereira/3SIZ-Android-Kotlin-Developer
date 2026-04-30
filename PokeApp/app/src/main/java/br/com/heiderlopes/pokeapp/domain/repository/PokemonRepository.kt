package br.com.heiderlopes.pokeapp.domain.repository

import br.com.heiderlopes.pokeapp.domain.common.Resource
import br.com.heiderlopes.pokeapp.domain.model.Pokemon


interface PokemonRepository {
    suspend fun getPokemonByNumber(number: Int): Resource<Pokemon>
}