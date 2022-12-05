package com.ms.musicmanagement.screen.albumdetails.uimodel

import com.ms.musicmanagement.shared.model.ui.ArtistUiModel

data class AlbumDetailsUiModel(
    val id: String,
    val name: String,
    val mbid: String?,
    val artist: ArtistUiModel?,
    val largeImageUrl: String?,
    val tracks: List<String>
)
