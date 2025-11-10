package com.example.ludoboardgames.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GameSearchBar(
    label: String,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClear: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            label = { Text(label) },
            trailingIcon = {
                IconButton(onClick = {
                    onSearch(searchText) }) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Buscar")
                }
            },
            modifier = Modifier.fillMaxWidth()
                .padding(end = 8.dp)
        )

        if (searchText.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                horizontalArrangement =
                    Arrangement.End
            ) {
                Text(
                    text = "Limpar filtro",
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        onClear() })
            }
        }
    }
}