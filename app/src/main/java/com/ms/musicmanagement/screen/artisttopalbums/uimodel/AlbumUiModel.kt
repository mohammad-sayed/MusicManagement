package com.ms.musicmanagement.screen.artisttopalbums.uimodel

data class AlbumUiModel(
    val id: String,
    val name: String,
    val mbid: String?,
    val mediumImageUrl: String?,
    val largeImageUrl: String?,
    val isFavorite: Boolean,
)
