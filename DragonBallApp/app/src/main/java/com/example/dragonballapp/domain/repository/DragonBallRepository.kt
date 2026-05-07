package com.example.dragonballapp.domain.repository

import com.example.dragonballapp.domain.common.Resource
import com.example.dragonballapp.domain.model.DragonBall

interface DragonBallRepository {
    suspend fun getDragonBallByNumber(number: Int): Resource<DragonBall>
}