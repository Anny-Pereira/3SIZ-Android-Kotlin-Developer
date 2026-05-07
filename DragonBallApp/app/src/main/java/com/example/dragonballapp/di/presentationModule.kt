package com.example.dragonballapp.di

import com.example.dragonballapp.presentation.dragonball.detail.DragonBallDetailViewModel
import com.example.dragonballapp.presentation.dragonball.search.DragonBallSearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel{
        DragonBallSearchViewModel()
    }
    viewModel {
        DragonBallDetailViewModel(get())
    }

}