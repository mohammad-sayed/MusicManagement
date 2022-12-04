package com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto

interface GetArtistTopAlbumsUseCase {
    suspend operator fun invoke(artistName: String): List<AlbumDto>
}
