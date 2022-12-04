package com.ms.musicmanagement.shared.datasource.backend

import com.ms.musicmanagement.shared.datasource.backend.constant.LastFMApiParameters
import com.ms.musicmanagement.shared.model.backend.getalbuminfo.GetAlbumInfoResponse
import com.ms.musicmanagement.shared.model.backend.getartisttopalbums.GetTopAlbumsResponse
import com.ms.musicmanagement.shared.model.backend.searchforartist.SearchForArtistResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFMRetrofitService {

    @GET("?${LastFMApiParameters.Key.METHOD}=${LastFMApiParameters.Value.Artist.METHOD_SEARCH}")
    suspend fun searchForArtist(
        @Query(value = LastFMApiParameters.Key.ARTIST)
        searchQuery: String,
    ): Response<SearchForArtistResponse>

    @GET("?${LastFMApiParameters.Key.METHOD}=${LastFMApiParameters.Value.Artist.METHOD_GET_TOP_ALBUMS}")
    suspend fun getArtistTopAlbums(
        @Query(value = LastFMApiParameters.Key.ARTIST)
        artistName: String,
    ): Response<GetTopAlbumsResponse>

    @GET("?${LastFMApiParameters.Key.METHOD}=${LastFMApiParameters.Value.Album.METHOD_GET_INFO}")
    suspend fun getAlbumInfo(
        @Query(value = LastFMApiParameters.Key.ARTIST)
        artistName: String,
        @Query(value = LastFMApiParameters.Key.ALBUM)
        albumName: String
    ): Response<GetAlbumInfoResponse>
}
