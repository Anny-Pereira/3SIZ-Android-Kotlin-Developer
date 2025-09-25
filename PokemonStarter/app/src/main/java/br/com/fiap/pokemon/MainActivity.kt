package br.com.fiap.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.pokemon.ui.theme.PokemonStarteSelectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonStarteSelectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonStarterScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokemonStarteSelectionTheme {
        Greeting("Android")
    }
}

//classe
data class Pokemon(
    val name: String = "",
    val imageRes: Int =
        R.drawable.pokeball_unselected
)

val starters = listOf(
    Pokemon("Bulbasaur", R.drawable.bulbassaur),
    Pokemon("Charmander",
        R.drawable.charmander),
    Pokemon("Squirtle", R.drawable.squirtle)
)

//componente
@Composable
fun PokemonStarterScreen(
    modifier: Modifier = Modifier
) {

    var pokemonSelected by remember {
        mutableStateOf(starters.first())
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally,
        verticalArrangement =
            Arrangement.spacedBy(16.dp)
    ) {
        PokeHeader(
            "Escolha seu Pokémon inicial"
        )

        PokemonCard(pokemonSelected)

        PokemonOptionsList(
            options = starters,
            pokemonSelected = pokemonSelected,
            onSelected = { pokemonSelected = it },
        )


    }
}


@Composable
fun PokeHeader(
    label: String,
) {
    Text(
        text = label,
        fontSize = 22.0.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun PokemonCard(pokemon: Pokemon) {
    Column(horizontalAlignment =
        Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id =
                pokemon.imageRes),
            contentDescription = pokemon.name,
            modifier = Modifier.size(250.dp)
        )
        Text(
            text = pokemon.name.uppercase(),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun PokemonOption(
    selected: Boolean,
    pokemon: Pokemon,
    onSelected: (Pokemon) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onSelected(pokemon) }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = if (selected)
                painterResource(id =
                    R.drawable.pokeball_selected) else painterResource(
                id = R.drawable.pokeball_unselected
            ),
            contentDescription = pokemon.name,
            modifier = Modifier.size(40.dp),
            colorFilter = if(isSystemInDarkTheme() &&
                !selected) ColorFilter.tint(Color.White) else null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = pokemon.name, fontSize = 18.sp)
    }
}

@Composable
fun PokemonOptionsList(
    options: List<Pokemon>,
    pokemonSelected: Pokemon,
    onSelected: (Pokemon) -> Unit,
) {
    Row(horizontalArrangement =
        Arrangement.spacedBy(8.dp)) {
        options.forEach { pokemon ->
            PokemonOption(
                pokemon = pokemon,
                selected = pokemon ==
                        pokemonSelected,
                onSelected = onSelected
            )
        }
    }
}