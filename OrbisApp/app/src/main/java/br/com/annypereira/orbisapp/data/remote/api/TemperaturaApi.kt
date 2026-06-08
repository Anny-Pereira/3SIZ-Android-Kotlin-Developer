package br.com.annypereira.orbisapp.data.remote.api

import br.com.annypereira.orbisapp.data.remote.dto.RespostaTemperaturaDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TemperaturaApi {

    @GET("forecast")
    suspend fun buscarTemperaturaSolo(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String = "soil_temperature_0cm",
        @Query("timezone") timezone: String = "America/Sao_Paulo"
    ): RespostaTemperaturaDto
}