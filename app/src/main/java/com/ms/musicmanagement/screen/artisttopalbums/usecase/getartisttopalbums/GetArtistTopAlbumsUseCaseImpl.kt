package com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums

import com.ms.musicmanagement.shared.model.backend.ImageSize
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.repository.cach.CacheRepository
import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepository

class GetArtistTopAlbumsUseCaseImpl(
    private val lastFMRepository: LastFMRepository,
    private val cacheRepository: CacheRepository
) : GetArtistTopAlbumsUseCase {
    override suspend fun invoke(artistName: String): List<AlbumDto> {
        return if (artistName.isBlank()) {
            emptyList()
        } else {
            val response = lastFMRepository.getArtistTopAlbums(artistName = artistName)
            val cachedAlbums = cacheRepository.getAlbums()
            return response.topAlbums.albums.map { album ->
                AlbumDto(
                    id = album.name,
                    name = album.name,
                    mbid = album.mbid,
                    artistName = album.artist.name,
                    mediumImageUrl = album.imageResolutions.firstOrNull { it.size == ImageSize.MEDIUM }?.url,
                    largeImageUrl = album.imageResolutions.firstOrNull { it.size == ImageSize.LARGE }?.url,
                    isFavorite = cachedAlbums.firstOrNull { cachedAlbum -> cachedAlbum.name == album.name } != null
                )
            }
        }
    }
}
