package com.ms.musicmanagement.shared.usecase.cachealbum

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto

interface CacheAlbumUseCase {
    suspend operator fun invoke(albumDto: AlbumDto)
}
