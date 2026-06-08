package br.com.annypereira.orbisapp.domain.usecase

import br.com.annypereira.orbisapp.domain.repository.ClimaRepository

class BuscarCidadesUseCase(
    private val repository: ClimaRepository
) {

    suspend operator fun invoke(
        cidade: String
    ) = repository.buscarCidades(cidade)

}