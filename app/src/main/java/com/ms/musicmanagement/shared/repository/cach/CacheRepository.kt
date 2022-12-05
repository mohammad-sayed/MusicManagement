package com.ms.musicmanagement.shared.repository.cach

import com.ms.musicmanagement.shared.model.database.Album
import kotlinx.coroutines.flow.Flow

interface CacheRepository {
    suspend fun getAlbumsFlow(): Flow<List<Album>>
    suspend fun getAlbums(): List<Album>
    suspend fun addAlbum(album: Album)
    suspend fun deleteAlbum(albumName: String)
}
