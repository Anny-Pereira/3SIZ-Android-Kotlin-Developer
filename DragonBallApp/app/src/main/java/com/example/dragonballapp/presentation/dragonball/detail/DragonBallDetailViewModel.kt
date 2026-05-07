package com.example.dragonballapp.presentation.dragonball.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dragonballapp.domain.common.Resource
import com.example.dragonballapp.domain.model.DragonBall
import com.example.dragonballapp.domain.usecase.GetDragonBallbyNumberUseCase
import com.example.dragonballapp.presentation.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DragonBallDetailViewModel(
    private val getDragonBallByNumberUseCase: GetDragonBallbyNumberUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<DragonBall>>(
        UiState.Initial
    )
    val uiState: StateFlow<UiState<DragonBall>> = _uiState

    fun getDragonBallByNumber(number: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            when (val result = getDragonBallByNumberUseCase(number)) {
                is Resource.Success -> {
                    _uiState.value = UiState.Success(result.data)
                }

                is Resource.Error -> {
                    _uiState.value = UiState.Error(result.message)
                }

                Resource.Loading -> {
                    _uiState.value = UiState.Loading
                }
            }
        }
    }
}