package br.com.rm553793.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.rm553793.R

@Composable
fun HarryLogo(modifier: Modifier = Modifier) {
    Image( painter = painterResource(id = R.drawable.harry_potter_logo),
        contentDescription = "Logo App" ,
        modifier = Modifier.padding(16.dp))
}