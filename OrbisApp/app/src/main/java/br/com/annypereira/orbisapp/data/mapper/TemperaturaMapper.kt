package br.com.annypereira.orbisapp.data.mapper

import br.com.annypereira.orbisapp.data.remote.dto.RespostaTemperaturaDto
import br.com.annypereira.orbisapp.domain.model.TemperaturaSolo

fun RespostaTemperaturaDto.toDomain(): TemperaturaSolo {

    return TemperaturaSolo(
        temperatura = hourly.soil_temperature_0cm.first(),
        horario = hourly.time.first()
    )
}