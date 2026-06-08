package br.com.annypereira.orbisapp.data.mapper

import br.com.annypereira.orbisapp.data.remote.dto.CidadeDto
import br.com.annypereira.orbisapp.domain.model.Cidade

fun CidadeDto.toDomain(): Cidade {

    return Cidade(
        nome = nome,
        latitude = latitude,
        longitude = longitude
    )
}