package br.com.annypereira.viacepapp.model

data class CepResponse(
    val cep: String?,
    val logradouro: String?,
    val bairro: String?,
    val localidade: String?,
    val estado: String?,
    val regiao: String?,
    val uf: String?,
)