package br.com.annypereira.orbisapp.data.remote

import br.com.annypereira.orbisapp.data.model.CidadeResponse
import br.com.annypereira.orbisapp.data.model.TemperaturaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoApi {

    @GET("v1/search")
    suspend fun buscarCidade(
        @Query("name") cidade: String
    ): CidadeResponse

    @GET("v1/forecast")
    suspend fun buscarTemperaturaSolo(

        @Query("latitude")
        latitude: Double,

        @Query("longitude")
        longitude: Double,

        @Query("hourly")
        hourly: String = "soil_temperature_0cm",

        @Query("timezone")
        timezone: String = "America/Sao_Paulo"

    ): TemperaturaResponse

}