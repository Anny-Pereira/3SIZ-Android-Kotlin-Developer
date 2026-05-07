package com.example.dragonballapp

import android.app.Application
import com.example.dragonballapp.di.dataModule
import com.example.dragonballapp.di.domainModule
import com.example.dragonballapp.di.networkModule
import com.example.dragonballapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DragonBallApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DragonBallApplication)

            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}