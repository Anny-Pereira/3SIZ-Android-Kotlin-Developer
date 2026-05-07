package com.example.dragonballapp.data.remote

import com.example.dragonballapp.data.model.DragonBallResponse

interface DragonBallRemoteDataSource {
    suspend fun getDragonBallByNumber(number: Int): DragonBallResponse
}