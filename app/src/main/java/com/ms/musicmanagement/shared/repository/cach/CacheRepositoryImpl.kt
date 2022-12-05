package com.ms.musicmanagement.shared.repository.cach

import com.ms.musicmanagement.shared.model.database.Album
import com.ms.musicmanagement.shared.model.database.dao.AlbumDao
import kotlinx.coroutines.flow.Flow

class CacheRepositoryImpl(
    private val albumDao: AlbumDao,
) : CacheRepository {

    override suspend fun getAlbums(): Flow<List<Album>> {
        return albumDao.getAllAlbums()
    }

    override suspend fun addAlbum(album: Album) {
        albumDao.insert(album)
    }

    override suspend fun deleteAlbum(albumName: String) {
        albumDao.deleteAlbumById(albumName = albumName)
    }
}
