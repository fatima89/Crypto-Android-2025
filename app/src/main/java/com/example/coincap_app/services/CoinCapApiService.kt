package com.example.coincap_app.services

import javax.inject.Inject
import com.example.coincap_app.models.Asset
import com.example.coincap_app.models.AssetsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class CoinCapApiService @Inject constructor(
    private val client: HttpClient

) {
    suspend fun  getAssets():AssetsResponse{
        val response: HttpResponse = client.get(urlString = "")
        return response.body()
    }
}
