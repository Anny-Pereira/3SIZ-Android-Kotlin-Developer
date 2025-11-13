package br.com.rm553793.rm552852.gs.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.rm553793.rm552852.gs.ui.models.Categoria
import spacingMedium

@Composable
fun CategoriaList(categorias: List<Categoria>){
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {
        itemsIndexed(categorias) { _, categoria ->
            CategoriaItem( categoria)
        }
    }
}