package com.arctouch.codechallenge

import android.app.Application
import com.arctouch.codechallenge.core.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(allModules)
        }
    }
}