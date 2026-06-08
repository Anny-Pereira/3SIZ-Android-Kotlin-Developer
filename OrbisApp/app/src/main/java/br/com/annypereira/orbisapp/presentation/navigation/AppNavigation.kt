package br.com.annypereira.orbisapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.annypereira.orbisapp.data.local.PreferenciasManager
import br.com.annypereira.orbisapp.presentation.screens.FavoritosScreen
import br.com.annypereira.orbisapp.presentation.screens.HomeScreen
import br.com.annypereira.orbisapp.presentation.screens.Onboarding
import br.com.annypereira.orbisapp.presentation.screens.SplashScreen
import br.com.annypereira.orbisapp.presentation.screens.TelaBusca
import br.com.annypereira.orbisapp.presentation.screens.TelaDetalhes

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val context = LocalContext.current

    val preferenciasManager = remember {
        PreferenciasManager(context)
    }

    NavHost(
        navController = navController,
        startDestination = Navegacao.Splash.rota
    ) {

        composable(
            Navegacao.Splash.rota
        ) {

            SplashScreen(
                navController = navController
            )

        }

        composable(
            Navegacao.Onboarding.rota
        ) {

            Onboarding(
                navController = navController,
                preferenciasManager = preferenciasManager
            )
        }

        composable(
            Navegacao.Busca.rota
        ) {
            TelaBusca(navController)
        }

        composable(
            Navegacao.Inicio.rota
        ) { backStackEntry ->

            val cidade =
                backStackEntry.arguments
                    ?.getString("cidade") ?: ""

            val latitude =
                backStackEntry.arguments
                    ?.getString("latitude")
                    ?.toDouble() ?: 0.0

            val longitude =
                backStackEntry.arguments
                    ?.getString("longitude")
                    ?.toDouble() ?: 0.0

            HomeScreen(
                cidade = cidade,
                latitude = latitude,
                longitude = longitude,
                navController
            )
        }

        composable(
            Navegacao.Favoritos.rota
        ) {

            FavoritosScreen(navController)

        }

        composable(
            Navegacao.Detalhe.rota
        ) {

            TelaDetalhes(navController)

        }

    }

}

