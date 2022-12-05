package com.ms.musicmanagement.screen.albumdetails.usecase.getcachedalbum

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import kotlinx.coroutines.flow.Flow

interface GetCachedAlbumUseCase {
    suspend operator fun invoke(albumName: String): AlbumDto
}
