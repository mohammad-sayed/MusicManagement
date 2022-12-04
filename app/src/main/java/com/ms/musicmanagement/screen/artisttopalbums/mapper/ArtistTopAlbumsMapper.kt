package com.ms.musicmanagement.screen.artisttopalbums.mapper

import com.ms.musicmanagement.screen.artistsearch.uimodel.ArtistUiModel
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto

object ArtistTopAlbumsMapper {
    fun mapAlbumDtoToAlbumUiModel(albumDto: AlbumDto): AlbumUiModel {
        return AlbumUiModel(
            id = albumDto.id,
            name = albumDto.name,
            mediumImageUrl = albumDto.mediumImageUrl,
            largeImageUrl = albumDto.largeImageUrl
        )
    }
}