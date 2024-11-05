package com.mobile.crypto.domain.utils

sealed class NetworkResult<out T> {

    data class Success<out T>(val data: T): NetworkResult<T>()
    data class NetworkError(val e: Throwable): NetworkResult<Nothing>()
    data class ClientError(val e: Throwable): NetworkResult<Nothing>()
}