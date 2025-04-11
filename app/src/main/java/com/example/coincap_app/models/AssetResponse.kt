package com.example.coincap_app.models

import kotlinx.serialization.Serializable

@Serializable
data class AssetResponse (
val id:String,
val name: String,
val symbol: String,
val priceUsd: String,
val percentage: String,
val changePercent24Hr : String

) {

}