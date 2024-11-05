package com.mobile.crypto

import android.app.Application
import com.mobile.crypto.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Crypto: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Crypto)
            modules(appModule)
        }
    }
}