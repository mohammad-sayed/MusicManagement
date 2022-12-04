package com.ms.musicmanagement.shared.repository.lastfm

import com.ms.musicmanagement.shared.datasource.backend.LastFMBackendDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LastFMRepositoryImpl(
    val lastFMBackendDataSource: LastFMBackendDataSource
) : LastFMRepository {

    override suspend fun searchForArtist(searchQuery: String) = withContext(Dispatchers.IO) {
        return@withContext lastFMBackendDataSource.searchForArtist(searchQuery = searchQuery)
    }
}
