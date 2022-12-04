package com.ms.musicmanagement.shared.datasource.backend

import com.ms.musicmanagement.shared.model.backend.getartisttopalbums.GetTopAlbumsResponse
import com.ms.musicmanagement.shared.model.backend.searchforartist.SearchForArtistResponse

interface LastFMBackendDataSource {

    suspend fun searchForArtist(searchQuery: String): SearchForArtistResponse

    suspend fun getArtistTopAlbums(artistName: String): GetTopAlbumsResponse

}
