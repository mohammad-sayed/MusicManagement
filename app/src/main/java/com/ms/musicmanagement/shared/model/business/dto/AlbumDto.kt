package com.ms.musicmanagement.shared.model.business.dto

data class AlbumDto(
    val id: String,
    val name: String,
    val mediumImageUrl: String?,
    val largeImageUrl: String?,
    val artistDto: ArtistDto? = null,
    val tracks: List<String>? = null,
    val isFavorite: Boolean
)
