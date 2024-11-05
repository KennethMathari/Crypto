package com.mobile.crypto.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mobile.crypto.data.network.CryptoService
import com.mobile.crypto.data.repository.CryptoRepositoryImpl
import com.mobile.crypto.data.utils.Constants.BASE_URL
import com.mobile.crypto.domain.CryptoRepository
import com.mobile.crypto.ui.viewmodel.CryptoViewModel
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val appModule = module {

    single<CryptoService> {
        val retrofit = get<Retrofit>()
        retrofit.create()
    }

    single<Retrofit> {
        Retrofit.Builder().baseUrl(BASE_URL).client(get())
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())).build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder().build()
    }

    single<CryptoRepository> {
        CryptoRepositoryImpl(
            cryptoService = get()
        )
    }

    viewModelOf(::CryptoViewModel)
}