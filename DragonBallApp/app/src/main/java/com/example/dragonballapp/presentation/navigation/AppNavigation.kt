package com.example.dragonballapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dragonballapp.presentation.dragonball.detail.DragonBallDetailScreen
import com.example.dragonballapp.presentation.dragonball.list.DragonBallListScreen
import com.example.dragonballapp.presentation.dragonball.search.DragonBallSearchScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.DRAGONBALL_LIST
    ) {
        composable(AppRoutes.DRAGONBALL_LIST) {
            DragonBallListScreen(
                onSearchClick = {
                    navController.navigate(AppRoutes.DRAGONBALL_SEARCH)
                },
                onDragonBallClick = { dragonBallNumber ->
                    navController.navigate(
                        AppRoutes.dragonBallDetail(dragonBallNumber)
                    )
                }
            )
        }

        composable(AppRoutes.DRAGONBALL_SEARCH) {
            DragonBallSearchScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSearchDragonBallClick = { dragonBallNumber ->
                    navController.navigate(
                        AppRoutes.dragonBallDetail(dragonBallNumber)
                    )
                }
            )
        }

        composable(
            route = AppRoutes.DRAGONBALL_DETAIL,
            arguments = listOf(
                navArgument("dragonballNumber") {
                    type = NavType.IntType
                }
            )

        ) { backStackEntry ->
            val dragonBallNumber = backStackEntry.arguments?.getInt("dragonballNumber") ?: 1

            DragonBallDetailScreen(
                dragonBallNumber = dragonBallNumber,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}