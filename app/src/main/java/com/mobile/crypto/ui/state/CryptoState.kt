package com.mobile.crypto.ui.state

import com.mobile.crypto.data.model.CryptoDTO
import kotlinx.serialization.SerialName

data class CryptoState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val cryptoDTO: CryptoDTO? = null
)
