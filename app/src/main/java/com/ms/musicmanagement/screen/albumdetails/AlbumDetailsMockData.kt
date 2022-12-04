package com.ms.musicmanagement.screen.albumdetails

import com.ms.musicmanagement.screen.albumdetails.uimodel.AlbumDetailsUiModel
import com.ms.musicmanagement.shared.model.ui.ArtistUiModel

object AlbumDetailsMockData {
    val albumDetails = AlbumDetailsUiModel(
        id = "1",
        largeImageUrl = "https://lastfm.freetls.fastly.net/i/u/174s/3b54885952161aaea4ce2965b2db1638.png",
        name = "Believe",
        artist = ArtistUiModel(
            id = "1",
            name = "Cher",
            imageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png"
        ),
        tracks = listOf(
            "track 1",
            "track 2"
        )
    )
}