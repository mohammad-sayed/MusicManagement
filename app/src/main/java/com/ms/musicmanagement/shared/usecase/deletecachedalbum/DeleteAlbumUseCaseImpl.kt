package com.ms.musicmanagement.shared.usecase.deletecachedalbum

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.database.Album
import com.ms.musicmanagement.shared.repository.cach.CacheRepository

class DeleteAlbumUseCaseImpl(
    private val cacheRepository: CacheRepository
) : DeleteAlbumUseCase {
    override suspend fun invoke(albumName: String) {
        cacheRepository.deleteAlbum(albumName = albumName)
    }
}
