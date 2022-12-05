package com.ms.musicmanagement.shared.usecase.deletecachedalbum

import com.ms.musicmanagement.shared.model.business.dto.AlbumDto

interface DeleteAlbumUseCase {
    suspend operator fun invoke(albumName: String)
}
