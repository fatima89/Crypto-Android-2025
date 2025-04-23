package com.example.coincap_app.services

import javax.inject.Inject
import com.example.coincap_app.models.AssetsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class CoinCapApiService @Inject constructor(
    private val client: HttpClient

) {
    suspend fun  getAssets():AssetsResponse{
        val response: HttpResponse = client.get(urlString = "https://rest.coincap.io/v3/assets?apiKey=5cfd9d1b42ff449053e5105cb44c7c872f472b104eb2c4d72098bf309665e2fa")
        return response.body()
    }
}