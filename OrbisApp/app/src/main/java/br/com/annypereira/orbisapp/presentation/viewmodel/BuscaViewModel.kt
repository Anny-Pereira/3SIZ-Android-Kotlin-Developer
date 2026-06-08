package br.com.annypereira.orbisapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.annypereira.orbisapp.data.model.Cidade
import br.com.annypereira.orbisapp.data.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BuscaViewModel : ViewModel() {

    private val _cidades = MutableStateFlow<List<Cidade>>(emptyList())

    val cidades: StateFlow<List<Cidade>> = _cidades

    private val _erro = MutableStateFlow<String?>(null)

    val erro: StateFlow<String?> = _erro

    fun buscarCidade(nome: String) {

        viewModelScope.launch {

            try {

                if (nome.isBlank()) {

                    _erro.value =
                        "Digite uma cidade"

                    return@launch

                }

                _erro.value = null
                val resposta = RetrofitInstance.api.buscarCidade(nome)

                if (resposta.results.isNullOrEmpty()) {

                    _cidades.value = emptyList()

                    _erro.value = "Cidade não encontrada"

                } else {

                    _cidades.value = resposta.results

                }

            } catch (e: Exception) {

                _erro.value = "Erro ao consultar serviço"

            }

        }

    }

}