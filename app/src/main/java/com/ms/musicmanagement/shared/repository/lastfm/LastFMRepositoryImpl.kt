package com.ms.musicmanagement.shared.repository.lastfm

import com.ms.musicmanagement.shared.datasource.backend.LastFMBackendDataSource
import com.ms.musicmanagement.shared.model.backend.getartisttopalbums.GetTopAlbumsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LastFMRepositoryImpl(
    val lastFMBackendDataSource: LastFMBackendDataSource
) : LastFMRepository {

    override suspend fun searchForArtist(searchQuery: String) = withContext(Dispatchers.IO) {
        return@withContext lastFMBackendDataSource.searchForArtist(searchQuery = searchQuery)
    }

    override suspend fun getArtistTopAlbums(artistName: String) = withContext(Dispatchers.IO) {
        return@withContext lastFMBackendDataSource.getArtistTopAlbums(artistName = artistName)
    }

    override suspend fun getAlbumInfo(artistName: String, albumName: String) =
        withContext(Dispatchers.IO) {
            return@withContext lastFMBackendDataSource.getAlbumInfo(
                artistName = artistName,
                albumName = albumName
            )
        }
}
