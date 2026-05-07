package com.example.dragonballapp.di

import com.example.dragonballapp.data.remote.DragonBallRemoteDataSource
import com.example.dragonballapp.data.remote.DragonBallRemoteDataSourceImpl
import com.example.dragonballapp.data.repository.DragonBallRepositoryImpl
import com.example.dragonballapp.domain.repository.DragonBallRepository
import org.koin.dsl.module

val dataModule = module {

    single<DragonBallRemoteDataSource> {
        DragonBallRemoteDataSourceImpl(api = get())
    }

    single<DragonBallRepository> {
        DragonBallRepositoryImpl(remoteDataSource = get())
    }
}