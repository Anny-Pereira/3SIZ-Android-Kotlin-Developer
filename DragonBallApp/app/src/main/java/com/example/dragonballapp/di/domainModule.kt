package com.example.dragonballapp.di

import com.example.dragonballapp.domain.usecase.GetDragonBallbyNumberUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetDragonBallbyNumberUseCase(repository = get())
    }
}