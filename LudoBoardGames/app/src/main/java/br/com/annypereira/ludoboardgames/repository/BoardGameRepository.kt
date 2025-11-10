package br.com.annypereira.ludoboardgames.repository

import br.com.annypereira.ludoboardgames.model.BoardGame
import br.com.annypereira.ludoboardgames.model.GamePublisher

fun getAllBoardGames(): List<BoardGame> {
    return listOf(
        BoardGame("Azul", listOf(Asmodee)),
        BoardGame(
            "Ticket To Ride",
            listOf(Asmodee)
        ),
        BoardGame(
            "Quem Foi?",
            listOf(PaperGames)
        ),
    )
}

fun getBoardGamesBy(
    gamePublisher:
    GamePublisher
): List<BoardGame> {
    return getAllBoardGames().filter {
        it.gamesPublisher.contains(gamePublisher)
    }
}

fun getBoardGamesBy(title: String):
        List<BoardGame> {
    return getAllBoardGames().filter {
        it.title.startsWith(
            prefix =
                title, ignoreCase = true
        )
    }
}