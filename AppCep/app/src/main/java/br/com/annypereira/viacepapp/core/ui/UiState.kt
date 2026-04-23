package br.com.annypereira.viacepapp.core.ui

//classe selada - funciona para ser reutilizável e geneérica para o projeto - enum extremamente poderoso
//generics - é generico e pode receber N tipos diferentes
sealed class UiState<out T>{

    data object Initial: UiState<Nothing>()

    data object Loading: UiState<Nothing>()

    data class Sucess<T>(
        //generico (pode ser um cep, uma pessoa, etc)
        val data: T
    ) : UiState<T>()

    data class Error(
        val message: String
    ) : UiState<Nothing>()
}