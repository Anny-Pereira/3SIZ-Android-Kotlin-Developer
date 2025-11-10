package br.com.annypereira.ludoboardgames.model

data class BoardGame(
    val title: String,
    val gamesPublisher: List<GamePublisher>
)