package com.example.coincap_app

import com.example.coincap_app.services.CoinCapApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton
import  io.ktor.serialization.kotlinx.json.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json
import io.ktor.client.engine.cio.CIO


@Module
@InstallIn(SingletonComponent:: class)
object AppModule {

    @Provides
    @Singleton
    fun ktorClient(): HttpClient {
        return HttpClient()
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }

    @Provides
    @Singleton
    fun coinCapService(client: HttpClient): CoinCapApiService{
        return CoinCapApiService(client)
    }
}