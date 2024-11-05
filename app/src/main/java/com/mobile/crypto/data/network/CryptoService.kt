package com.mobile.crypto.data.network

import com.mobile.crypto.data.model.CryptoDTO
import retrofit2.http.GET

interface CryptoService {

    @GET("/v2/assets?limit=20&offset=0")
    suspend fun getCryptoList(): CryptoDTO
}