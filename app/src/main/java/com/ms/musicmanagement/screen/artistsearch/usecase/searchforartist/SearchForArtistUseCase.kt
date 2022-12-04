package com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist

import com.ms.musicmanagement.shared.model.business.dto.ArtistDto

interface SearchForArtistUseCase {
    suspend operator fun invoke(searchQuery: String): List<ArtistDto>
}
