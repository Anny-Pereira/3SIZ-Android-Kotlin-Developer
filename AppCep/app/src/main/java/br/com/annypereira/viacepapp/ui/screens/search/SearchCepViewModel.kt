package br.com.annypereira.viacepapp.ui.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.annypereira.viacepapp.core.ui.UiState
import br.com.annypereira.viacepapp.model.CepResponse
import br.com.annypereira.viacepapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class SearchCepViewModel : ViewModel(){

    //pode ser alterada dentro da ViewModel e atraves da tela
    var cep by mutableStateOf("")
        //encapsula a variavel - o metodo de alterar é privado
        private set

    var uiState by mutableStateOf<UiState<CepResponse>>(UiState.Initial)
        private set


    fun onCepChange(newValue: String){
        //só capta o que é digito e retorna os 8 primeiros numeros
        cep = newValue.filter { it.isDigit() }.take(8)

        if (uiState is UiState.Error){
            uiState = UiState.Initial
        }
    }

    fun searchCep(){
        uiState = UiState.Loading
        val cepClear = cep.filter { it.isDigit() }
        if(cepClear.length != 8){
            uiState = UiState.Error("CEP inválido")
            return
        }

        //faz o app rodar o bloco numa thread fora da thread principal
        // roda em segundo plano para não travar a aplicação
        //como se fosse uma chamada assincrona
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.viaCepApi.searchCep(cepClear)
                uiState = UiState.Sucess(response)
            } catch (e: Exception){
                uiState = UiState.Error("Erro ao buscar o CEP")
            }

        }
    }

}