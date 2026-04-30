package br.com.heiderlopes.pokeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.heiderlopes.pokeapp.presentation.pokemon.detail.PokemonDetailScreen
import br.com.heiderlopes.pokeapp.presentation.pokemon.list.PokemonListScreen
import br.com.heiderlopes.pokeapp.presentation.pokemon.search.PokemonSearchScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.POKEMON_LIST
    ) {
        composable(AppRoutes.POKEMON_LIST) {
            PokemonListScreen(
                onSearchClick = {
                    navController.navigate(AppRoutes.POKEMON_SEARCH)
                },
                onPokemonClick = { pokemonNumber ->
                    navController.navigate(
                        AppRoutes.pokemonDetail(pokemonNumber)
                    )
                }
            )
        }

        composable(AppRoutes.POKEMON_SEARCH) {
            PokemonSearchScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSearchPokemonClick = { pokemonNumber ->
                    navController.navigate(
                        AppRoutes.pokemonDetail(pokemonNumber)
                    )
                }
            )
        }

        composable(
            route = AppRoutes.POKEMON_DETAIL,
            arguments = listOf(
                navArgument("pokemonNumber") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val pokemonNumber = backStackEntry.arguments?.getInt("pokemonNumber") ?: 1

            PokemonDetailScreen(
                pokemonNumber = pokemonNumber,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}