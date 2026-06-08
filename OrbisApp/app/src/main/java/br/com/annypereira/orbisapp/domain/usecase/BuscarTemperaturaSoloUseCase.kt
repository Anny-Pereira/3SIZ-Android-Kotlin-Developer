package br.com.annypereira.orbisapp.domain.usecase

import br.com.annypereira.orbisapp.domain.repository.ClimaRepository

class BuscarTemperaturaSoloUseCase(
    private val repository: ClimaRepository
) {

    suspend operator fun invoke(
        latitude: Double,
        longitude: Double
    ) = repository.buscarTemperaturaSolo(
        latitude,
        longitude
    )

}