package br.com.rm553793.rm552852.gs.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import iconTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BalanceOnTopBar(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {},
    onLikeClick: () -> Unit = {}
) {
    val colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.background
    )

    TopAppBar(
        modifier = modifier,
        colors = colors,
        title = { AppLogo() }
    )
}