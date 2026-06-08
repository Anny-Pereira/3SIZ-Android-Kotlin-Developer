package br.com.annypereira.orbisapp.data.remote.api

import br.com.annypereira.orbisapp.data.remote.dto.RespostaGeocodingDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("search")
    suspend fun buscarCidade(
        @Query("name") cidade: String
    ): RespostaGeocodingDto
}