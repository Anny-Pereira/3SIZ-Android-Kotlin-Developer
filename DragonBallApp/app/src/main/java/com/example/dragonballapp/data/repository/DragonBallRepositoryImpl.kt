package com.example.dragonballapp.data.repository

import com.example.dragonballapp.data.model.toDomain
import com.example.dragonballapp.data.remote.DragonBallRemoteDataSource
import com.example.dragonballapp.domain.common.Resource
import com.example.dragonballapp.domain.model.DragonBall
import com.example.dragonballapp.domain.repository.DragonBallRepository

class DragonBallRepositoryImpl(
    private val remoteDataSource: DragonBallRemoteDataSource
) : DragonBallRepository {

    override suspend fun getDragonBallByNumber(number: Int): Resource<DragonBall> {
        return try {
            val response = remoteDataSource.getDragonBallByNumber(number)
            Resource.Success(response.toDomain())
        } catch (exception: Exception) {
            val error = exception.message
            Resource.Error("Não foi possível buscar o personagem.")
        }
    }
}