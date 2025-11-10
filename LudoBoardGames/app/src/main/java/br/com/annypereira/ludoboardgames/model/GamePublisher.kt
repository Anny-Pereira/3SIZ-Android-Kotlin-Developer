package br.com.annypereira.ludoboardgames.model

import android.graphics.Color
import androidx.annotation.DrawableRes

data class GamePublisher(
    val title: String,
    @DrawableRes val imageId: Int
)