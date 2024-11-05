package com.mobile.crypto.data.repository

import com.mobile.crypto.data.model.CryptoDTO
import com.mobile.crypto.data.network.CryptoService
import com.mobile.crypto.domain.CryptoRepository
import com.mobile.crypto.domain.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class CryptoRepositoryImpl(
    private val cryptoService: CryptoService
) : CryptoRepository {
    override suspend fun getCryptoList(): Flow<NetworkResult<CryptoDTO>> {
        return withContext(Dispatchers.IO) {
            flow {
                try {
                    val response = cryptoService.getCryptoList()

                    NetworkResult.Success(response)

                } catch (e: HttpException) {
                    e.printStackTrace()
                    NetworkResult.ClientError(e)
                } catch (e: Exception) {
                    e.printStackTrace()
                    NetworkResult.NetworkError(e)
                }
            }
        }
    }
}