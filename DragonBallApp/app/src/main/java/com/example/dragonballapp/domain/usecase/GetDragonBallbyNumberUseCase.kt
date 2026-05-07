package com.example.dragonballapp.domain.usecase

import com.example.dragonballapp.domain.common.Resource
import com.example.dragonballapp.domain.model.DragonBall
import com.example.dragonballapp.domain.repository.DragonBallRepository

class GetDragonBallbyNumberUseCase(
    private val repository: DragonBallRepository
) {
    suspend operator fun invoke(number: Int): Resource<DragonBall> {
        if (number <= 0) {
            return Resource.Error("Informe um número maior que zero.")
        }

        if (number > 1025) {
            return Resource.Error("Informe um número válido até 1025.")
        }

        return repository.getDragonBallByNumber(number)
    }
}

