package com.ms.musicmanagement.shared.repository.lastfm

import com.ms.musicmanagement.shared.model.backend.searchforartist.SearchForArtistResponse
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto

interface LastFMRepository {
    suspend fun searchForArtist(searchQuery: String): SearchForArtistResponse
}
