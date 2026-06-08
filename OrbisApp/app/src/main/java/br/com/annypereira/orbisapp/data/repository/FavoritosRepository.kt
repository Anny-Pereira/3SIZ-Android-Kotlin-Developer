package br.com.annypereira.orbisapp.data.repository

import br.com.annypereira.orbisapp.domain.model.Favorito
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object FavoritosRepository {

    private val _favoritos =
        MutableStateFlow<List<Favorito>>(emptyList())

    val favoritos: StateFlow<List<Favorito>>
            = _favoritos

    fun adicionarFavorito(
        favorito: Favorito
    ) {

        val listaAtual =
            _favoritos.value.toMutableList()

        listaAtual.add(favorito)

        _favoritos.value = listaAtual

    }

}