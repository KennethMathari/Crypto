package com.mobile.crypto.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.crypto.domain.CryptoRepository
import com.mobile.crypto.domain.utils.NetworkResult
import com.mobile.crypto.ui.state.CryptoState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoViewModel(
    private val cryptoRepository: CryptoRepository
): ViewModel() {

    private val _cryptoState = MutableStateFlow(CryptoState())
    val cryptoState: StateFlow<CryptoState> get() = _cryptoState

    init {
        getCryptoList()
    }

    private fun getCryptoList(){
        viewModelScope.launch {
            _cryptoState.value = CryptoState(
                isLoading = true,
                errorMessage = null,
                cryptoDTO = null
            )

            cryptoRepository.getCryptoList().collect{ result->
                when(result){
                    is NetworkResult.ClientError -> {
                        _cryptoState.value = CryptoState(
                            isLoading = false,
                            errorMessage = "Failed to load list! Please Try Again",
                            cryptoDTO = null
                        )

                    }
                    is NetworkResult.NetworkError -> {

                        _cryptoState.value = CryptoState(
                            isLoading = false,
                            errorMessage = "Check internet Connection! Please Try Again",
                            cryptoDTO = null
                        )

                    }
                    is NetworkResult.Success -> {
                        _cryptoState.value = CryptoState(
                            isLoading = false,
                            errorMessage = null,
                            cryptoDTO = result.data
                        )

                        Log.e("Result", result.data.toString())

                    }

                    is NetworkResult.ServerError -> {
                        _cryptoState.value = CryptoState(
                            isLoading = false,
                            errorMessage = "Oops! Our Server is Down.",
                            cryptoDTO = null
                        )
                    }
                }
            }
        }
    }
}