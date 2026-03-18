package br.com.rm553793.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rm553793.ui.components.HarryLogo

@Composable
fun CaracteristaScreen(
    nextScreen: (String) -> Unit
) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HarryLogo()
        Spacer(modifier = Modifier.height(80.dp))
        Text("Escolha sua característica:")
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                nextScreen("Coragem")
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Coragem")
        }

        Button(
            onClick = {
                nextScreen("Inteligência")
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Inteligência")
        }

        Button(
            onClick = {
                nextScreen("Lealdade")
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Lealdade")
        }

        Button(
            onClick = {
               nextScreen("Ambição")
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Ambição")
        }
    }
}

@Preview
@Composable
private fun CaracteristicaScreenPreview() {
    CaracteristaScreen(){}
}