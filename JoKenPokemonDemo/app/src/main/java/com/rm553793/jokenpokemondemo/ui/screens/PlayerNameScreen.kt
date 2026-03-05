package com.rm553793.jokenpokemondemo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns
import com.rm553793.jokenpokemondemo.ui.components.PokemonLogo

@Composable
fun PlayerNameScreen(modifier: Modifier = Modifier) {

    var playerName by remember { mutableStateOf("") }

    //criando componente
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(16.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        PokemonLogo()
        Spacer(modifier = Modifier.height(80.dp))
        OutlinedTextField(
            value = playerName,
            onValueChange = { newText -> playerName = newText },
            label = { Text("Digite seu nome") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                //onNavigateToGenerateNumber(input.toInt())
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Iniciar Batalha")
        }
    }
}