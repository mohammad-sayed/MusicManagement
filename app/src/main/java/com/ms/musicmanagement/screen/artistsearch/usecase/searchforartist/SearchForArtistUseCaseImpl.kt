package com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist

import com.ms.musicmanagement.shared.model.backend.ImageSize
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto
import com.ms.musicmanagement.shared.repository.lastfm.LastFMRepository

class SearchForArtistUseCaseImpl(
    val lastFMRepository: LastFMRepository
) : SearchForArtistUseCase {
    override suspend fun invoke(searchQuery: String): List<ArtistDto> {
        return if (searchQuery.isBlank()) {
            emptyList()
        } else {
            val response = lastFMRepository.searchForArtist(searchQuery = searchQuery)
            return response.results.artistMatches.artistsList.map { artist ->
                ArtistDto(
                    id = artist.name,
                    name = artist.name,
                    imageUrl = artist.imageResolutions?.firstOrNull { it.size == ImageSize.MEDIUM }?.url
                )
            }
        }
    }
}
