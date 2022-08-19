package com.br.cartola.application

import android.app.Application
import com.br.cartola.di.daoModule
import com.br.cartola.di.viewModelModule
import com.br.cartola.di.webClientModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationModule : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationModule)
            modules(
                listOf(
                    webClientModule,
                    daoModule,
                    viewModelModule
                )
            )
        }
    }

}