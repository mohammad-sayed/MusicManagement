package com.ms.musicmanagement.screen.artistsearch.mapper

import com.ms.musicmanagement.screen.artistsearch.uimodel.ArtistUiModel
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto

object ArtistSearchMapper {
    fun mapArtistDtoToArtistUiModel(artistDto: ArtistDto): ArtistUiModel {
        return ArtistUiModel(
            id = artistDto.id,
            name = artistDto.name,
            imageUrl = artistDto.imageUrl,
        )
    }
}
