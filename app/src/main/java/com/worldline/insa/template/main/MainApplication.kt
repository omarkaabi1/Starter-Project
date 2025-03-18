package com.worldline.insa.template.main

import android.app.Application
import com.example.data.di.dataModuleCommon
import com.example.data.di.dataModuleNetwork
import com.example.domain.di.domainModule
import com.example.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(uiModule, dataModuleCommon, dataModuleNetwork, domainModule)
        }
    }
}