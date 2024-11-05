package com.mobile.crypto.domain.utils

sealed class NetworkResult<out D> {

    data class Success<out D>(val data: D): NetworkResult<D>()
    data class NetworkError(val e: Throwable): NetworkResult<Nothing>()
    data class ClientError(val e: Throwable): NetworkResult<Nothing>()
    data class ServerError(val e: Throwable): NetworkResult<Nothing>()
}