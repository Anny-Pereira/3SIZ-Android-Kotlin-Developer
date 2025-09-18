package com.example.goldwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goldwise.ui.theme.GoldWiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoldWiseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GoldWise(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GoldWise(modifier: Modifier = Modifier) {

    var quantity by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var context = LocalContext.current
    var avisoQtd by remember { mutableStateOf("") }
    var avisoPrice by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "Logo do app",
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                stringResource(R.string.app_name),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        OutlinedTextField(
            value = quantity,
            onValueChange = {
                quantity= it
                if (quantity.isEmpty()){
                    avisoQtd = "Preencha este campo"
                } else{
                    avisoQtd = ""
                }
                            },
            modifier = Modifier.fillMaxWidth(),
            label = {Text("Quantidade")},
            keyboardOptions = KeyboardOptions(
                //usando teclado numerico
                keyboardType = KeyboardType.Number
            )
        )
        Text(avisoQtd, style = TextStyle(
            color = androidx.compose.ui.graphics.Color.Red
        ))

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = price,
            onValueChange = {
                price = it
                if (price.isEmpty()){
                    avisoPrice = "Preencha este campo"
                } else{
                    avisoPrice = ""
                }
                            },
            modifier = Modifier.fillMaxWidth(),
            label = {Text("Preço")},
            keyboardOptions = KeyboardOptions(
                //usando teclado numerico
                keyboardType = KeyboardType.Decimal
            )
        )
        Text(avisoPrice, style = TextStyle(
            color = androidx.compose.ui.graphics.Color.Red
        ))

        Spacer(modifier = Modifier.height(12.dp))
        Button( //o que vai fazer
            onClick = {
                if (price.isEmpty() || quantity.isEmpty()){
                    resultado = "Preencha todos os campos"
                } else{
                    val total = quantity.toDouble() * price.toDouble()
                    resultado = context.getString(R.string.total, total)
                }
            },
            modifier = Modifier.fillMaxWidth()

        ) { //o que vai renderizar
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(
            onClick = {
                quantity = ""
                price = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpar")
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(resultado)


    }
}

@Preview(showBackground = true)
@Composable
fun GoldWisePreview(modifier: Modifier = Modifier) {
    GoldWiseTheme {
        GoldWise()
    }
}