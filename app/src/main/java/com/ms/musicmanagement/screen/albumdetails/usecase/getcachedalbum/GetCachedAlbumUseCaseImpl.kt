package com.ms.musicmanagement.screen.albumdetails.usecase.getcachedalbum

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.repository.cach.CacheRepository
import kotlinx.coroutines.flow.callbackFlow

class GetCachedAlbumUseCaseImpl(
    private val cacheRepository: CacheRepository
) : GetCachedAlbumUseCase {
    override suspend fun invoke(albumName: String): AlbumDto {
        val album = cacheRepository.getAlbumById(albumName = albumName)
        return AlbumDto(
            id = album.id,
            name = album.name,
            mbid = album.mbid,
            artistName = album.artistName,
            mediumImageUrl = album.mediumImageUrl,
            largeImageUrl = album.largeImageUrl,
            tracks = album.tracks,
            isFavorite = true
        )
    }
}
