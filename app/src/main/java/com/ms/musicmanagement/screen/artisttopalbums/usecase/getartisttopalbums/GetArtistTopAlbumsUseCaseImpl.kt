package com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums

import com.ms.musicmanagement.shared.model.backend.ImageSize
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto
import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepository

class GetArtistTopAlbumsUseCaseImpl(
    private val lastFMRepository: LastFMRepository
) : GetArtistTopAlbumsUseCase {
    override suspend fun invoke(artistName: String): List<AlbumDto> {
        return if (artistName.isBlank()) {
            emptyList()
        } else {
            val response = lastFMRepository.getArtistTopAlbums(artistName = artistName)
            return response.topAlbums.albums.map { album ->
                AlbumDto(
                    id = album.name,
                    name = album.name,
                    mediumImageUrl = album.imageResolutions.firstOrNull { it.size == ImageSize.MEDIUM }?.url,
                    largeImageUrl = album.imageResolutions.firstOrNull { it.size == ImageSize.LARGE }?.url,
                    isFavorite = false
                )
            }
        }
    }
}
