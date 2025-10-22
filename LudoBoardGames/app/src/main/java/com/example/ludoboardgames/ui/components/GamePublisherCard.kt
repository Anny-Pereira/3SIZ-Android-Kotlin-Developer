package com.example.ludoboardgames.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ludoboardgames.models.GamePublisher

@Composable
fun GamePublisherCard(
    gamePublisher: GamePublisher,
    onClick: ((GamePublisher) -> Unit)? = null
) {
    Card(
        shape = CircleShape,
        modifier = Modifier.size(100.dp)
            .clickable(enabled = onClick != null) {
                onClick?.invoke(gamePublisher) },
        elevation =
            CardDefaults.cardElevation(defaultElevation =
                4.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement =
                Arrangement.Center,
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {
            Text(gamePublisher.name, textAlign =
                TextAlign.Center)
        }
    }

}