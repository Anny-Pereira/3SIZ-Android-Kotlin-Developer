package com.rm553793.jokenpokemondemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rm553793.jokenpokemondemo.R
import com.rm553793.jokenpokemondemo.ui.components.PokemonLogo

@Composable
fun JoKenPokemonScreen(
    playerName: String,
    onBackPressed: ( ) -> Unit
) {

    Scaffold { innerPadding ->

        Column (modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription =  "Trocar Jogador",
                        tint = Color.Black
                    )
                }
            }
        }


        //body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .fillMaxHeight()
                .padding(16.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PokemonLogo()
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = painterResource(R.drawable.pokeballvoid),
                        contentDescription = "Logo App",
                        modifier = Modifier.height(82.dp)
                    )
                    Text(playerName)
                }
                Column {
                    Image(
                        painter = painterResource(R.drawable.pokeballvoid),
                        contentDescription = "Logo App",
                        modifier = Modifier.height(82.dp)
                    )
                    Text("Computador")
                }
            }

            Spacer(modifier = Modifier.height(100.dp))
            //navbar
            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center) {
                    Text("Faça sua jogada de mestre")
                }
                Spacer(modifier = Modifier.height(10.dp))

                //linha
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Image(
                            painter = painterResource(R.drawable.pokeballvoid),
                            contentDescription = "Logo App",
                            modifier = Modifier.height(32.dp)
                        )
                        Text("Charmander",fontSize = 14.sp )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Image(
                            painter = painterResource(R.drawable.pokeballvoid),
                            contentDescription = "Logo App",
                            modifier = Modifier.height(32.dp)
                        )
                        Text("Bulbasaur",fontSize = 14.sp )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Image(
                            painter = painterResource(R.drawable.pokeballvoid),
                            contentDescription = "Logo App",
                            modifier = Modifier.height(32.dp)
                        )
                        Text("Squirtle",fontSize = 14.sp )
                    }

                }
            }
        }
    }


}