package com.rm553793.rm552852

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rm553793.rm552852.ui.theme.CP2TemperaturaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP2TemperaturaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CP2TemperaturaScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//RM 553793 - Anny Pereira
//RM 552852 - Giovanna Makida

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
    CP2TemperaturaTheme {
        Greeting("Android")
    }
}

@Composable
fun CP2TemperaturaScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally,
        verticalArrangement =
            Arrangement.spacedBy(16.dp)
    ) {
        TempHeader(
            "Conversor de Temperatura"
        )

        var temp by remember {
            mutableStateOf("")
        }

        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = temp,
            onValueChange = { temp = it },
            label = {
                Text(stringResource(R.string.temp))
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType =
                        KeyboardType.Number
                ),
            modifier = Modifier.fillMaxWidth()
        )

        val context = LocalContext.current
        var resultF by remember { mutableStateOf("") }
        var resultK by remember { mutableStateOf("") }

        Button(
            onClick = {
                if (temp.isBlank()) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.empty_field),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val tempCelsius = temp.toDouble()
                    val fahrenheit = tempCelsius * 9 / 5 + 32
                    val kelvin = tempCelsius + 273.15

                    resultF = context.getString(R.string.label_result_f, fahrenheit)
                    resultK = context.getString(R.string.label_result_k, kelvin)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.btn_converter))
        }

        OutlinedButton (
            onClick = {
                temp = ""
                resultF = ""
                resultK = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.btn_limpar))
        }


        //Resultados
        if (resultF.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = resultF,
                fontSize = 18.sp,
                modifier =
                    Modifier.align(Alignment.CenterHorizontally)
            )

        }

        if (resultK.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = resultK,
                fontSize = 18.sp,
                modifier =
                    Modifier.align(Alignment.CenterHorizontally)
            )

        }

    }

}

@Composable
fun TempHeader(
    label: String
) {
    Column(
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment =
                Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id =
                        R.drawable.thermometer
                ),
                contentDescription = ("logo"),
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = label,
                fontSize = 22.0.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }

}