package br.com.annypereira.orbisapp.domain.repository

import br.com.annypereira.orbisapp.domain.model.Cidade
import br.com.annypereira.orbisapp.domain.model.TemperaturaSolo

interface ClimaRepository {

    suspend fun buscarCidades(
        cidade: String
    ): List<Cidade>

    suspend fun buscarTemperaturaSolo(
        latitude: Double,
        longitude: Double
    ): TemperaturaSolo
}