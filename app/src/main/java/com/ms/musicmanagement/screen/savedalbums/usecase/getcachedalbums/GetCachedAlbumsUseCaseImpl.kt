package com.ms.musicmanagement.screen.savedalbums.usecase.getcachedalbums

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.repository.cach.CacheRepository
import kotlinx.coroutines.flow.callbackFlow

class GetCachedAlbumsUseCaseImpl(
    private val cacheRepository: CacheRepository
) : GetCachedAlbumsUseCase {
    override suspend fun invoke() = callbackFlow {
        cacheRepository.getAlbumsFlow().collect { albumsList ->
            val albumDtoList = albumsList.map { album ->
                AlbumDto(
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
            trySend(albumDtoList)
        }
    }
}
