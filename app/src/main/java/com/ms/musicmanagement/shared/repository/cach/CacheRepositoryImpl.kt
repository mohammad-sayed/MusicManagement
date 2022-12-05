package com.ms.musicmanagement.shared.repository.cach

import com.ms.musicmanagement.shared.model.database.Album
import com.ms.musicmanagement.shared.model.database.dao.AlbumDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CacheRepositoryImpl(
    private val albumDao: AlbumDao,
) : CacheRepository {

    override suspend fun getAlbumsFlow(): Flow<List<Album>> = withContext(Dispatchers.IO) {
        return@withContext albumDao.getAllAlbumsFlow()
    }

    override suspend fun getAlbums(): List<Album> = withContext(Dispatchers.IO) {
        return@withContext albumDao.getAllAlbums()
    }

    override suspend fun addAlbum(album: Album) = withContext(Dispatchers.IO) {
        albumDao.insert(album)
    }

    override suspend fun deleteAlbum(albumName: String) = withContext(Dispatchers.IO) {
        albumDao.deleteAlbumById(albumName = albumName)
    }
}
