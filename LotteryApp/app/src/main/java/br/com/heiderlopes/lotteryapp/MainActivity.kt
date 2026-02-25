package br.com.heiderlopes.lotteryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.heiderlopes.lotteryapp.navigation.AppNavGraph
import br.com.heiderlopes.lotteryapp.ui.screens.NumberAmountScreen
import br.com.heiderlopes.lotteryapp.ui.screens.ResultScreen
import br.com.heiderlopes.lotteryapp.ui.theme.LotteryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LotteryAppTheme {
               val navController = rememberNavController()
                AppNavGraph(navController)

            }
        }
    }
}
