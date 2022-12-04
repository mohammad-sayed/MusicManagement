package com.ms.musicmanagement.screen.albumdetails.usecase

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto

interface GetAlbumInfoUseCase {
    suspend fun invoke(
        artistName: String,
        albumName: String
    ): AlbumDto
}
