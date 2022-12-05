package com.ms.musicmanagement.screen.albumdetails.mapper

import com.ms.musicmanagement.screen.albumdetails.uimodel.AlbumDetailsUiModel
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.ui.ArtistUiModel

object AlbumDetailsMapper {
    fun mapAlbumDtoToAlbumUiModel(albumDto: AlbumDto): AlbumDetailsUiModel {
        return AlbumDetailsUiModel(
            id = albumDto.id,
            name = albumDto.name,
            mbid = albumDto.mbid,
            artistName = albumDto.artistName,
            largeImageUrl = albumDto.largeImageUrl,
            tracks = albumDto.tracks ?: emptyList(),
        )
    }
}