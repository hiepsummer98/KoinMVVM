package com.hiepsummer.koinmvvm.backend

import android.app.Application
import com.hiepsummer.koinmvvm.module.movieModule
import com.hiepsummer.koinmvvm.module.picassoModule
import com.hiepsummer.koinmvvm.module.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyCustomApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyCustomApp)
            modules(
                listOf(
                    retrofitModule,
                    picassoModule,
                    movieModule
                )
            )
        }
    }
}