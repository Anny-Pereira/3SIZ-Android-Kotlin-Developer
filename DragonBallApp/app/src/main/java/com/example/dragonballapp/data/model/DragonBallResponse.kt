package com.example.dragonballapp.data.model

import com.example.dragonballapp.domain.model.DragonBall
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class DragonBallResponse(
    val id: Int,
    val name: String,
    val image: String
)


fun DragonBallResponse.toDomain(): DragonBall {
    return DragonBall(
        id = id,
        name = name.replaceFirstChar { it.uppercase() },
        imageUrl = image
    )
}