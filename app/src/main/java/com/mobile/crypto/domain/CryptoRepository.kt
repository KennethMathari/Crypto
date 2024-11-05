package com.mobile.crypto.domain

import com.mobile.crypto.data.model.CryptoDTO
import com.mobile.crypto.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    suspend fun getCryptoList(): Flow<NetworkResult<CryptoDTO>>
}