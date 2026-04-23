package br.com.annypereira.viacepapp.network

import br.com.annypereira.viacepapp.model.CepResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
    @GET("{cep}/json/")
    suspend fun searchCep(
        @Path("cep") cep: String
    ): CepResponse
}