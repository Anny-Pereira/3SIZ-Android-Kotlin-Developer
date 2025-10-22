package com.example.ludoboardgames.repository

import com.example.ludoboardgames.models.GamePublisher

val asmodee = GamePublisher(name = "Asmodee")
val devir = GamePublisher(name = "Devir")
val paperGame = GamePublisher(name = "PaperGame")

fun getAllGamesPublisher() : List<GamePublisher> {
    return listOf(
        asmodee,
        devir,
        paperGame
    )
}
