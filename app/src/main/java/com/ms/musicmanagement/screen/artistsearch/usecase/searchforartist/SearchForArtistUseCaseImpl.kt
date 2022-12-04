package com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist

import com.ms.musicmanagement.shared.model.business.dto.ArtistDto
import kotlinx.coroutines.delay

class SearchForArtistUseCaseImpl : SearchForArtistUseCase {
    override suspend fun invoke(searchQuery: String): List<ArtistDto> {
        delay(500)
        return if (searchQuery.isBlank()) {
            emptyList()
        } else {
            val artistsDtoList = listOf(
                ArtistDto(
                    id = "1",
                    name = "Cher",
                    imageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png"
                ),
                ArtistDto(
                    id = "2",
                    name = "Cher Lloyd",
                    imageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png"
                ),
                ArtistDto(
                    id = "3",
                    name = "Cheryl Cole",
                    imageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png"
                ),
                ArtistDto(
                    id = "4",
                    name = "CHERRY BULLET",
                    imageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png"
                ),
            )
            artistsDtoList.filter { it.name.contains(searchQuery) }
        }
    }
}
