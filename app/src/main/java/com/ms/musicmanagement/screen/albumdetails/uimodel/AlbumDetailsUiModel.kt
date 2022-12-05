package com.ms.musicmanagement.screen.albumdetails.uimodel

data class AlbumDetailsUiModel(
    val id: String,
    val name: String,
    val mbid: String?,
    val artistName: String,
    val largeImageUrl: String?,
    val tracks: List<String>
)
