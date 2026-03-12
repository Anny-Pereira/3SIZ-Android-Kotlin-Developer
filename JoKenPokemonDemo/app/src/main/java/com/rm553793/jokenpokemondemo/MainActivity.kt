package com.rm553793.jokenpokemondemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rm553793.jokenpokemondemo.navigation.AppNavigation
import com.rm553793.jokenpokemondemo.ui.screens.JoKenPokemonScreen
import com.rm553793.jokenpokemondemo.ui.screens.PlayerNameScreen
import com.rm553793.jokenpokemondemo.ui.theme.JoKenPokemonDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JoKenPokemonDemoTheme {
                AppNavigation()
            }
        }
    }
}
