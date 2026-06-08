package br.com.annypereira.orbisapp.data.model

data class CidadeResponse(
    val results: List<Cidade>?
)

data class Cidade(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String?
)