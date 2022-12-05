package com.ms.musicmanagement.shared.model.business.dto

data class AlbumDto(
    val id: String,
    val name: String,
    val mbid: String?,
    val artistName: String,
    val mediumImageUrl: String?,
    val largeImageUrl: String?,
    val tracks: List<String>? = null,
    val isFavorite: Boolean
)
