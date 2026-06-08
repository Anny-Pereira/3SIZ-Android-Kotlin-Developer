package br.com.annypereira.orbisapp.data.remote.dto

data class HorarioDto(
    val time: List<String>,
    val soil_temperature_0cm: List<Double>
)