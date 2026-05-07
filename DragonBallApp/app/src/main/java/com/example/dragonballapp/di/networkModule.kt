package com.example.dragonballapp.di

import com.example.dragonballapp.data.remote.DragonBallApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {

        val trustAllCerts = arrayOf<TrustManager>(
            object : X509TrustManager {
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) = Unit

                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) = Unit

                override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
            }
        )

        val sslContext = SSLContext.getInstance("TLS").apply {
            init(null, trustAllCerts, SecureRandom())
        }

        val trustManager = trustAllCerts[0] as X509TrustManager

        OkHttpClient.Builder()
            .sslSocketFactory(sslContext.socketFactory, trustManager)
            .hostnameVerifier { _, _ -> true }
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Json {
            ignoreUnknownKeys = true
        }
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://dragon-ball-api-055bab372b94.herokuapp.com/api/"
            )
            .client(get())
            .addConverterFactory(
                get<Json>().asConverterFactory(
                    "application/json".toMediaType()
                )
            )
            .build()
    }

    single<DragonBallApi> {
        get<Retrofit>().create(DragonBallApi::class.java)
    }
}