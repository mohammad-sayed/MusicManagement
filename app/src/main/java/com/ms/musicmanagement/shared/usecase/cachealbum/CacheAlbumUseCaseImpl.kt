package com.ms.musicmanagement.shared.usecase.cachealbum

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.database.Album
import com.ms.musicmanagement.shared.repository.cach.CacheRepository

class CacheAlbumUseCaseImpl(
    private val cacheRepository: CacheRepository
) : CacheAlbumUseCase {

    override suspend fun invoke(
        albumDto: AlbumDto
    ) {
        cacheRepository.addAlbum(
            Album(
                id = albumDto.id,
                name = albumDto.name,
                mbid = albumDto.mbid,
                tracks = albumDto.tracks ?: emptyList(),
                mediumImageUrl = albumDto.mediumImageUrl,
                largeImageUrl = albumDto.largeImageUrl,
                artistName = albumDto.artistDto?.name ?: "",
            )
        )
    }
}
