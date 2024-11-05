package com.mobile.crypto.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mobile.crypto.data.network.CryptoService
import com.mobile.crypto.data.repository.CryptoRepositoryImpl
import com.mobile.crypto.data.utils.Constants.BASE_URL
import com.mobile.crypto.domain.CryptoRepository
import com.mobile.crypto.ui.viewmodel.CryptoViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit

val appModule = module {

    single<CoroutineDispatcher> {
        Dispatchers.IO
    }

    single<CryptoService> {
        val retrofit = get<Retrofit>()
        retrofit.create()
    }

    single<Retrofit> {
        val contentType = "application/json".toMediaType()

        Retrofit.Builder().baseUrl(BASE_URL).client(get())
            .addConverterFactory(Json.asConverterFactory(contentType)).build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS).retryOnConnectionFailure(true).build()
    }

    single<CryptoRepository> {
        CryptoRepositoryImpl(
            cryptoService = get(),
            ioDispatcher = get()
        )
    }

    viewModelOf(::CryptoViewModel)
}