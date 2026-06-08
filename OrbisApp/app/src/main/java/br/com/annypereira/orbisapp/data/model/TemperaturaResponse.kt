package br.com.annypereira.orbisapp.data.model

data class TemperaturaResponse(
    val hourly: Hourly
)

data class Hourly(
    val soil_temperature_0cm: List<Double>
)