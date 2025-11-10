package br.com.annypereira.ludoboardgames.repository

import android.R.attr.title
import androidx.compose.ui.graphics.Color
import br.com.annypereira.ludoboardgames.R
import br.com.annypereira.ludoboardgames.model.GamePublisher

val Asmodee = GamePublisher("Asmodee", R.drawable.asmodee)
val Devir = GamePublisher("Devir", R.drawable.asmodee)
val PaperGames = GamePublisher("PaperGames", R.drawable.asmodee)

fun getAllGamesPublisher(): List<GamePublisher> {
    return listOf(
        Asmodee,
        Devir,
        PaperGames
    )
}