package br.com.rm553793.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rm553793.ui.components.HarryLogo

@Composable
fun ResultScreen(
    caracterisca: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HarryLogo()
        Spacer(modifier = Modifier.height(80.dp))
        Text("Sua característica é : $caracterisca")

        if (caracterisca == "Coragem") {
            Text("Bem Vindo a Grifinória!")
            Image(
                painter = painterResource(id = R.drawable.gryffindor_1),
                contentDescription = "Grifnoria",
                modifier = Modifier.padding(16.dp)
            )

        } else if (caracterisca == "Inteligência") {
            Text("Bem Vindo a Corvinal!")
            Image(
                painter = painterResource(id = R.drawable.ravenclaw_1),
                contentDescription = "Corvinal",
                modifier = Modifier.padding(16.dp)
            )

        } else if (caracterisca == "Lealdade") {
            Text("Bem Vindo a Lufa-Lufa!")
            Image(
                painter = painterResource(id = R.drawable.hufflepuff_1),
                contentDescription = "Lufa-Lufa",
                modifier = Modifier.padding(16.dp)
            )

        } else if (caracterisca == "Ambição") {
            Text("Bem Vindo a Sonserina!")
            Image(
                painter = painterResource(id = R.drawable.slytherin_1),
                contentDescription = "Sonserina",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
