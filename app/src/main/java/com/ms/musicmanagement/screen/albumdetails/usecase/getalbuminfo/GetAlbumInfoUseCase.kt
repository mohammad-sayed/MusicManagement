package com.ms.musicmanagement.screen.albumdetails.usecase.getalbuminfo

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto

interface GetAlbumInfoUseCase {
    suspend operator fun invoke(
        artistName: String,
        albumName: String
    ): AlbumDto
}
