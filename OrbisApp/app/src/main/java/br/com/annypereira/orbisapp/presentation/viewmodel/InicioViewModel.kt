package br.com.annypereira.orbisapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.annypereira.orbisapp.data.remote.RetrofitTemperatura
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InicioViewModel : ViewModel() {

    private val _temperatura = MutableStateFlow<Double?>(null)

    val temperatura: StateFlow<Double?>
            = _temperatura

    private val _erro =
        MutableStateFlow<String?>(null)

    val erro: StateFlow<String?>
            = _erro

    fun buscarTemperatura(
        latitude: Double,
        longitude: Double
    ) {

        viewModelScope.launch {

            try {

                val resposta =
                    RetrofitTemperatura.api
                        .buscarTemperaturaSolo(
                            latitude = latitude,
                            longitude = longitude
                        )

                _temperatura.value =
                    resposta.hourly
                        .soil_temperature_0cm
                        .firstOrNull()

            } catch (e: Exception) {

                _erro.value =
                    "Erro ao consultar temperatura"

            }

        }

    }

}