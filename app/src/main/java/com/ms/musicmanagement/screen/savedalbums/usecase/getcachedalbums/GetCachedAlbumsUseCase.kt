package com.ms.musicmanagement.screen.savedalbums.usecase.getcachedalbums

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import kotlinx.coroutines.flow.Flow

interface GetCachedAlbumsUseCase {
    suspend operator fun invoke(): Flow<List<AlbumDto>>
}
