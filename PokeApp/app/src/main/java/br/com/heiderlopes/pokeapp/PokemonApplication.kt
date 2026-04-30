package br.com.heiderlopes.pokeapp

import android.app.Application
import br.com.heiderlopes.pokeapp.di.dataModule
import br.com.heiderlopes.pokeapp.di.domainModule
import br.com.heiderlopes.pokeapp.di.networkModule
import br.com.heiderlopes.pokeapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokemonApplication)

            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}