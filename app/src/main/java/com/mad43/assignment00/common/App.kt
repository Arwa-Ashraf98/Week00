package com.mad43.assignment00.common

import android.app.Application
import com.mad43.assignment00.di.appModule
import com.mad43.assignment00.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    //    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
//        appContainer = AppContainer()
        initKoin()

    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, viewModelModule))
        }
    }
}