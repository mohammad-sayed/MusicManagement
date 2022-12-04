package com.ms.musicmanagement.koin

import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepository
import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepositoryImpl
import org.koin.dsl.module

/**
 * This property is used to create Repositories and inject needed parameters
 * */
val repositoryModule = module {
    single<LastFMRepository> {
        LastFMRepositoryImpl(
            lastFMBackendDataSource = get()
        )
    }
}
