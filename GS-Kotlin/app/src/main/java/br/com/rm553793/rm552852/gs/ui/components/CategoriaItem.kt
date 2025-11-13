package br.com.rm553793.rm552852.gs.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rm553793.rm552852.gs.R
import br.com.rm553793.rm552852.gs.ui.models.Categoria
import coil.compose.AsyncImage
import spacingSmall

@Composable
fun CategoriaItem(categoria: Categoria) {
    Column (
        modifier = Modifier
            .padding(spacingSmall)
            .background(MaterialTheme.colorScheme.background)
    ) {

        AsyncImage(
            model = categoria.imagem,
            contentDescription = stringResource(
                R.string.story_content_description,
                categoria.titulo
            ),
            modifier = Modifier
                .size(52.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
            //contentScale = ContentScale.Fit
            //placeholder = painterResource(R.drawable.placeholder), // opcional
            //error = painterResource(R.drawable.error) // opcional
        )

        Text(
            categoria.titulo, modifier = Modifier
                .width(72.dp)
                .height(24.dp),
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

//@Preview
//@Composable
//fun CategoriaItemPreview(modifier: Modifier = Modifier) {
//    CategoriaItem(Categoria("", ""))
//}