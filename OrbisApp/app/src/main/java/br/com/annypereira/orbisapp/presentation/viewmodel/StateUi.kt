package br.com.annypereira.orbisapp.presentation.viewmodel

sealed interface StateUi<out T> {

    object Inicial : StateUi<Nothing>

    object Carregando : StateUi<Nothing>

    data class Sucesso<T>(
        val dados: T
    ) : StateUi<T>

    data class Erro(
        val mensagem: String
    ) : StateUi<Nothing>
}