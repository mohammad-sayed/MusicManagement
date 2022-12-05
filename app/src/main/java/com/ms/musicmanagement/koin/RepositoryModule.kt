package com.ms.musicmanagement.koin

import com.ms.musicmanagement.shared.datasource.database.MusicManagementRoomDatabase
import com.ms.musicmanagement.shared.repository.cach.CacheRepository
import com.ms.musicmanagement.shared.repository.cach.CacheRepositoryImpl
import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepository
import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * This property is used to create Repositories and inject needed parameters
 * */
val repositoryModule = module {
    single<LastFMRepository> {
        LastFMRepositoryImpl(
            lastFMBackendDataSource = get(),
        )
    }
    single<CacheRepository> {
        val database = MusicManagementRoomDatabase.getDatabase(androidContext())
        CacheRepositoryImpl(
            albumDao = database.albumDao(),
        )
    }
}
