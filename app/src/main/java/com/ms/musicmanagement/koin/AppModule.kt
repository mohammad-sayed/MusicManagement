package com.ms.musicmanagement.koin

import com.ms.musicmanagement.shared.datasource.backend.LastFMBackendDataSource
import com.ms.musicmanagement.shared.datasource.backend.LastFMBackendDataSourceImpl
import org.koin.dsl.module

/**
 * This property is used to create objects of classes which depends on nothing or just a Context to be created
 * */
val appModule = module {
    single<LastFMBackendDataSource> { LastFMBackendDataSourceImpl() }
}
