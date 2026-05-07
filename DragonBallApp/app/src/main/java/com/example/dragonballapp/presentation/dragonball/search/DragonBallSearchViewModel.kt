package com.example.dragonballapp.presentation.dragonball.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DragonBallSearchViewModel : ViewModel() {

    private val _dragonballNumber = MutableStateFlow("")
    val dragonballNumber: StateFlow<String> = _dragonballNumber

    fun onDragonBallNumberChanged(value: String) {
        _dragonballNumber.value = value.filter { it.isDigit() }
    }

    fun getDragonBallNumberOrNull(): Int? {
        return _dragonballNumber.value.toIntOrNull()
    }
}