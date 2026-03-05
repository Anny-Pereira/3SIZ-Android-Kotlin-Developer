package com.rm553793.jokenpokemondemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.rm553793.jokenpokemondemo.R

@Composable
fun PokemonLogo(modifier: Modifier = Modifier) {

    Image( painter = painterResource(id = R.drawable.logo_pokemon),
        contentDescription = "Logo App" )

}