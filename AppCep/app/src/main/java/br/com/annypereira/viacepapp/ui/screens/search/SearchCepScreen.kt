package br.com.annypereira.viacepapp.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.annypereira.viacepapp.core.ui.UiState
import br.com.annypereira.viacepapp.model.CepResponse

@Composable
fun SearchCepScreen(
    searchCepViewModel: SearchCepViewModel = viewModel()
) {

    val cep = searchCepViewModel.cep
    val uiState = searchCepViewModel.uiState

    Scaffold { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
        ){

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Text("Digite um CEP para buscar o endereço")
                Spacer(modifier = Modifier.height((16.dp)))
                OutlinedTextField(
                    value = searchCepViewModel.cep,
                    onValueChange = {searchCepViewModel.onCepChange(it)},
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {searchCepViewModel.searchCep()},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Pesquisar")
                }
                Spacer(modifier = Modifier.height(16.dp))

                when(uiState){
                    is UiState.Error -> Text(uiState.message)
                    UiState.Initial -> {}
                    UiState.Loading -> CircularProgressIndicator()
                    is UiState.Sucess<CepResponse> -> Text(uiState.data.logradouro ?: "")
                }
            }
        }

    }

}