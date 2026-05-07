package com.example.dragonballapp.data.remote

import com.example.dragonballapp.data.model.DragonBallResponse

class DragonBallRemoteDataSourceImpl(
    private val api: DragonBallApi
) : DragonBallRemoteDataSource {
    override suspend fun getDragonBallByNumber(number: Int): DragonBallResponse {
        return api.getDragonBallByNumber(number)
    }
}