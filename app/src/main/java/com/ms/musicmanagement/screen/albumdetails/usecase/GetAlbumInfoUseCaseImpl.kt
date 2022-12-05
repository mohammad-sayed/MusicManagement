package com.ms.musicmanagement.screen.albumdetails.usecase

import com.ms.musicmanagement.shared.model.backend.ImageSize
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto
import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepository

class GetAlbumInfoUseCaseImpl(
    private val lastFMRepository: LastFMRepository
) : GetAlbumInfoUseCase {
    override suspend fun invoke(
        artistName: String,
        albumName: String
    ): AlbumDto {
        val response = lastFMRepository.getAlbumInfo(
            artistName = artistName,
            albumName = albumName
        )
        return AlbumDto(
            id = response.album.name,
            name = response.album.name,
            mbid = response.album.mbid,
            mediumImageUrl = response.album.imageResolutions.firstOrNull { it.size == ImageSize.MEDIUM }?.url,
            largeImageUrl = response.album.imageResolutions.firstOrNull { it.size == ImageSize.LARGE }?.url,
            tracks = response.album.tracks.tracksList.map { it.name },
            artistDto = ArtistDto(
                id = response.album.artist,
                name = response.album.artist,
                imageUrl = null
            ),
            isFavorite = false
        )
    }
}
