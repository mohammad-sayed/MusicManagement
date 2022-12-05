package com.ms.musicmanagement.screen.albumdetails

import com.ms.musicmanagement.screen.albumdetails.uimodel.AlbumDetailsUiModel
import com.ms.musicmanagement.shared.model.ui.ArtistUiModel

object AlbumDetailsMockData {
    val albumDetails = AlbumDetailsUiModel(
        id = "1",
        mbid = "12",
        largeImageUrl = "https://lastfm.freetls.fastly.net/i/u/174s/3b54885952161aaea4ce2965b2db1638.png",
        name = "Believe",
        artistName = "Cher",
        tracks = listOf(
            "track 1",
            "track 2"
        )
    )
}