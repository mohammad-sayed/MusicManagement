package com.ms.musicmanagement.shared.repository.lastfm

import com.ms.musicmanagement.shared.model.backend.getalbuminfo.GetAlbumInfoResponse
import com.ms.musicmanagement.shared.model.backend.getartisttopalbums.GetTopAlbumsResponse
import com.ms.musicmanagement.shared.model.backend.searchforartist.SearchForArtistResponse
import com.ms.musicmanagement.shared.model.business.dto.ArtistDto

interface LastFMRepository {
    suspend fun searchForArtist(searchQuery: String): SearchForArtistResponse
    suspend fun getArtistTopAlbums(artistName: String): GetTopAlbumsResponse
    suspend fun getAlbumInfo(
        artistName: String,
        albumName: String
    ): GetAlbumInfoResponse
}
