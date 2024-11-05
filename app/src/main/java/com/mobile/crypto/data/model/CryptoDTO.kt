package com.mobile.crypto.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoDTO(
    @SerialName("data")
    val `data`: List<Data>,
    @SerialName("timestamp")
    val timestamp: Long
)