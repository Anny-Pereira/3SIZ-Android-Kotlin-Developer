package br.com.rm553793.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.rm553793.ui.screens.CaracteristaScreen
import br.com.rm553793.ui.screens.HomeScreen
import br.com.rm553793.ui.screens.ResultScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        //começa por essa tela
        startDestination = "welcome"
    ){

        composable("welcome"){
            HomeScreen(){
                navController.navigate("carac")
            }
        }

        composable("carac"){
            CaracteristaScreen(){
                navController.navigate("result/$it")
            }
        }

        composable("result/{caracteristica}",
            arguments = listOf(navArgument("caracteristica"){
                type = NavType.StringType
            })
        ){
                backStackEntry ->
            val carac = backStackEntry.arguments?.getString("caracteristica")
                ?: "Desconhecido"
            ResultScreen(carac)
        }
    }

}