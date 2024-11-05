package com.mobile.crypto.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobile.crypto.ui.viewmodel.CryptoViewModel
import okhttp3.internal.trimSubstring
import org.koin.androidx.compose.koinViewModel

@Composable
fun CryptoScreen(
    cryptoViewModel: CryptoViewModel = koinViewModel()
){

    val cryptoState by cryptoViewModel.cryptoState.collectAsState()

    Column {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("#")
            Text("Name")
            Text("24h")
            Text("Price")
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items( cryptoState.cryptoDTO?.data ?: emptyList()){ crypto->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("1")
                    Text(crypto.name)
                    Text(String.format("%.2f", crypto.changePercent24Hr.toDouble()) + "%")
                    Text(" $${crypto.priceUsd.toDouble().toInt()}")
                }

                HorizontalDivider(thickness = 2.dp)

            }
        }
    }
}