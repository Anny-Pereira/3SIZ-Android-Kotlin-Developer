package br.com.annypereira.orbisapp.di

import br.com.annypereira.orbisapp.data.remote.api.GeocodingApi
import br.com.annypereira.orbisapp.data.remote.api.TemperaturaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private val retrofitGeocoding =
        Retrofit.Builder()
            .baseUrl(
                "https://geocoding-api.open-meteo.com/v1/"
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

    private val retrofitWeather =
        Retrofit.Builder()
            .baseUrl(
                "https://api.open-meteo.com/v1/"
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

    val geocodingApi: GeocodingApi =
        retrofitGeocoding.create(
            GeocodingApi::class.java
        )

    val temperaturaApi: TemperaturaApi =
        retrofitWeather.create(
            TemperaturaApi::class.java
        )
}