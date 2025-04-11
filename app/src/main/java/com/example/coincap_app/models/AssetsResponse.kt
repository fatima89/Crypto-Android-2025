package com.example.coincap_app.models
import kotlinx.serialization.Serializable

@Serializable
data class AssetsResponse (
    val data: List<AssetResponse>
)