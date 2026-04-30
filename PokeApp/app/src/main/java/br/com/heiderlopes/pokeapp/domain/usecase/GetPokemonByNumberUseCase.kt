package br.com.heiderlopes.pokeapp.domain.usecase

import br.com.heiderlopes.pokeapp.domain.common.Resource
import br.com.heiderlopes.pokeapp.domain.model.Pokemon
import br.com.heiderlopes.pokeapp.domain.repository.PokemonRepository

class GetPokemonByNumberUseCase(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(number: Int): Resource<Pokemon> {
        if (number <= 0) {
            return Resource.Error("Informe um número maior que zero.")
        }

        if (number > 1025) {
            return Resource.Error("Informe um número válido até 1025.")
        }

        return repository.getPokemonByNumber(number)
    }
}