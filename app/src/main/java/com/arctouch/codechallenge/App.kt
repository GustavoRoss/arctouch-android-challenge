package com.arctouch.codechallenge

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
//            modules(appModules, domainModules, dataModules)
        }
    }
}