package com.mobile.crypto.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mobile.crypto.ui.viewmodel.CryptoViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CryptoScreen(
    cryptoViewModel: CryptoViewModel = koinViewModel()
){

    val cryptoState by cryptoViewModel.cryptoState.collectAsState()

    Column {
        LazyColumn {
            items( cryptoState.cryptoDTO?.data ?: emptyList()){ crypto->

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text("# Name")
                    Text("24h")
                    Text("Price")
                }

                Row{
                    Text(crypto.name)
                    Text(crypto.changePercent24Hr)
                    Text(crypto.priceUsd)
                }

            }
        }
    }
}