package com.rm553793.jokenpokemondemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rm553793.jokenpokemondemo.ui.screens.JoKenPokemonScreen
import com.rm553793.jokenpokemondemo.ui.screens.PlayerNameScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        //navController - classe que auxilia na navegação de telas
        navController = navController,
        //começa por essa tela
        startDestination = "name"
    ){
        //declara todas as telas

        //tela login
        composable("name"){
            PlayerNameScreen(){
                navController.navigate("game/$it")
            }
        }

        //tela game
        composable("game/{playerName}",
            //define lista de argumentos recebidos pela tela
            arguments = listOf(navArgument("playerName"){
                type = NavType.StringType
            })
            ){
            backStackEntry ->
            val playername = backStackEntry.arguments?.getString("playerName")
                ?: "Desconhecido" //caso o 'playerName' seja nulo usar esse valor (if ternario)
            JoKenPokemonScreen(playername) {
                navController.popBackStack()
            }
        }
    }

}