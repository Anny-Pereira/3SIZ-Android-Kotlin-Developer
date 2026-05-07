package com.example.dragonballapp.data.remote

import com.example.dragonballapp.data.model.DragonBallResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DragonBallApi {
    @GET("characters/{number}")
    suspend fun getDragonBallByNumber(
        @Path("number") number: Int
    ): DragonBallResponse
}