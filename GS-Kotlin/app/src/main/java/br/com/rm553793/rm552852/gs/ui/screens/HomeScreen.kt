package br.com.rm553793.rm552852.gs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rm553793.rm552852.gs.ui.components.BalanceOnTopBar
import br.com.rm553793.rm552852.gs.ui.components.CategoriaList
import br.com.rm553793.rm552852.gs.ui.components.SearchBar
import br.com.rm553793.rm552852.gs.ui.models.Categoria
import br.com.rm553793.rm552852.gs.ui.repositories.categorias

@Composable
fun HomeScreen() {
    var searchTextState by remember { mutableStateOf("") }
    Scaffold(
        topBar = { BalanceOnTopBar() },
        modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(16.dp)
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            CategoriaList(categorias)
            Spacer(modifier = Modifier.height(30.dp))
            SearchBar(
                label= "Buscar atividades ou categorias",
                searchText = searchTextState,
                onSearchTextChange = {
                    searchTextState = it
                },
                onSearch = {
                    //algo
                },
                onClear = {
                    searchTextState=""
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}