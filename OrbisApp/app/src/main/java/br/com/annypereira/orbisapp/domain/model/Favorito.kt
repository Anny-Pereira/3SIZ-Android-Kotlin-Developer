package br.com.annypereira.orbisapp.domain.model

data class Favorito(

    val cidade: String,

    val latitude: Double,

    val longitude: Double,

    val temperatura: Double? = null

)