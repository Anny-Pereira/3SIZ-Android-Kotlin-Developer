package br.com.annypereira.orbisapp.presentation.navigation

import androidx.navigation.compose.rememberNavController

sealed class Navegacao(val rota: String) {

    object Splash : Navegacao("splash")

    object Onboarding : Navegacao("onboarding")

    object Busca : Navegacao("busca")

    object Inicio : Navegacao("inicio/{cidade}/{latitude}/{longitude}") {

        fun criarRota(
            cidade: String,
            latitude: Double,
            longitude: Double
        ): String {
            return "inicio/$cidade/$latitude/$longitude"
        }
    }

    object Favoritos : Navegacao("favoritos")

    object Detalhe : Navegacao("detalhe")

}