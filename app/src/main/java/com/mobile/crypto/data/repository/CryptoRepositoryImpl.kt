package com.mobile.crypto.data.repository

import com.mobile.crypto.data.model.CryptoDTO
import com.mobile.crypto.data.network.CryptoService
import com.mobile.crypto.data.utils.safeApiCall
import com.mobile.crypto.domain.CryptoRepository
import com.mobile.crypto.domain.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class CryptoRepositoryImpl(
    private val cryptoService: CryptoService,
    private val ioDispatcher: CoroutineDispatcher
) : CryptoRepository {

    override suspend fun getCryptoList(): Flow<NetworkResult<CryptoDTO>> {
        return flow {
                val result = safeApiCall {
                    cryptoService.getCryptoList()
                }
                emit(result)
            }.flowOn(ioDispatcher)
        }
}