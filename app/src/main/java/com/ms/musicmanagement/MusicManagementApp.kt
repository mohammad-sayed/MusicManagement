package com.ms.musicmanagement

import android.app.Application
import com.ms.musicmanagement.koin.appModule
import com.ms.musicmanagement.koin.repositoryModule
import com.ms.musicmanagement.koin.useCaseModule
import com.ms.musicmanagement.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MusicManagementApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MusicManagementApp)
            /** Modules should be added in the following order:
             * 1. appModule
             * 2. repositoryModule
             * 3. useCaseModule
             * 4. viewModelModule
             */
            modules(appModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }
}
