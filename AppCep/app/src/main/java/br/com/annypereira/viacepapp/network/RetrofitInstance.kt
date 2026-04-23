package br.com.annypereira.viacepapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Este objeto cria a conexão com o servidor da API.
object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val viaCepApi = retrofit.create(ViaCepApi::class.java)
}