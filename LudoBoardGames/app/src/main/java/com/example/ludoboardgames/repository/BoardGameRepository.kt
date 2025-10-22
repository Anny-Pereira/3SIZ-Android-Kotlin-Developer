package com.example.ludoboardgames.repository

import com.example.ludoboardgames.models.BoardGame
import com.example.ludoboardgames.models.GamePublisher

class BoardGameRepository {
}

fun getAllBoardGames() : List<BoardGame> {
    return listOf(
        BoardGame("Azul", listOf(asmodee)),
        BoardGame("Ticket To Ride", listOf(asmodee)),
        BoardGame("Quem foi?", listOf(paperGame))
    )
}


fun getBoardGameBy(
    gamePublisher: GamePublisher
) : List<BoardGame> {
    return getAllBoardGames().filter {
        it.gamePublisher.contains(gamePublisher)
    }
}

fun getBoardGamesBy(title: String):
        List<BoardGame> {
    return getAllBoardGames().filter {
        it.title.startsWith(prefix =
            title, ignoreCase = true)
    }
}