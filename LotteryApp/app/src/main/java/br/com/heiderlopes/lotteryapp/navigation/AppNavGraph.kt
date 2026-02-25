package br.com.heiderlopes.lotteryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.heiderlopes.lotteryapp.ui.screens.NumberAmountScreen
import br.com.heiderlopes.lotteryapp.ui.screens.ResultScreen


@Composable
fun AppNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Routes.Input.route) {

        composable(Routes.Input.route) {
            NumberAmountScreen() { amount ->
                navController.navigate(Routes.Result.createRoute(amount))
            }
        }

        composable(Routes.Result.route, arguments = listOf(
            navArgument(Routes.Result.Args.AMOUNT){
                type = NavType.IntType
                defaultValue = 6
            }
        )) {
            val amount = it.arguments?.getInt(Routes.Result.Args.AMOUNT) ?: 6
            ResultScreen(amount)
        }

    }
}