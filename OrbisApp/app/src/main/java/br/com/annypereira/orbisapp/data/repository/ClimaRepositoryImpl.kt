package br.com.annypereira.orbisapp.data.repository

import br.com.annypereira.orbisapp.data.mapper.toDomain
import br.com.annypereira.orbisapp.data.remote.api.GeocodingApi
import br.com.annypereira.orbisapp.data.remote.api.TemperaturaApi
import br.com.annypereira.orbisapp.domain.model.Cidade
import br.com.annypereira.orbisapp.domain.model.TemperaturaSolo
import br.com.annypereira.orbisapp.domain.repository.ClimaRepository

class ClimaRepositoryImpl(
    private val geocodingApi: GeocodingApi,
    private val temperaturaApi: TemperaturaApi
) : ClimaRepository {
    override suspend fun buscarCidades(
        cidade: String
    ): List<Cidade> {

        return geocodingApi
            .buscarCidade(cidade)
            .results
            .map {
                it.toDomain()
            }
    }

    override suspend fun buscarTemperaturaSolo(
        latitude: Double,
        longitude: Double
    ): TemperaturaSolo {

        return temperaturaApi
            .buscarTemperaturaSolo(
                latitude,
                longitude
            )
            .toDomain()
    }
}