package com.ms.musicmanagement.screen.albumdetails.mapper

import com.ms.musicmanagement.screen.albumdetails.uimodel.AlbumDetailsUiModel
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.ui.ArtistUiModel

object AlbumDetailsMapper {
    fun mapAlbumDtoToAlbumUiModel(albumDto: AlbumDto): AlbumDetailsUiModel {
        return AlbumDetailsUiModel(
            id = albumDto.id,
            name = albumDto.name,
            mbid = albumDto.mbid,
            largeImageUrl = albumDto.largeImageUrl,
            tracks = albumDto.tracks ?: emptyList(),
            artist = ArtistUiModel(
                id = albumDto.artistDto?.name ?: "",
                name = albumDto.artistDto?.name ?: "",
                imageUrl = albumDto.artistDto?.imageUrl
            )
        )
    }
}