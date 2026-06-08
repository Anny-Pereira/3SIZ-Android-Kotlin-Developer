package br.com.annypereira.orbisapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import br.com.annypereira.orbisapp.data.repository.ClimaRepositoryImpl
import br.com.annypereira.orbisapp.di.NetworkModule
import br.com.annypereira.orbisapp.presentation.navigation.AppNavigation
import br.com.annypereira.orbisapp.presentation.screens.SplashScreen
import br.com.annypereira.orbisapp.ui.theme.OrbisAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            OrbisAppTheme {

                AppNavigation()

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
        OrbisAppTheme {
            Greeting("Android")
        }
    }
}