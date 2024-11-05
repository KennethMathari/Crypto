package com.mobile.crypto.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("changePercent24Hr")
    val changePercent24Hr: String,
    @SerialName("explorer")
    val explorer: String,
    @SerialName("id")
    val id: String,
    @SerialName("marketCapUsd")
    val marketCapUsd: String,
    @SerialName("maxSupply")
    val maxSupply: String?,
    @SerialName("name")
    val name: String,
    @SerialName("priceUsd")
    val priceUsd: String,
    @SerialName("rank")
    val rank: String,
    @SerialName("supply")
    val supply: String,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("volumeUsd24Hr")
    val volumeUsd24Hr: String,
    @SerialName("vwap24Hr")
    val vwap24Hr: String
)