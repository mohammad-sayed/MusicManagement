package com.ms.musicmanagement.screen.artisttopalbums

import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel

object ArtistTopAlbumsMockData {

    val topAlbums = listOf(
        AlbumUiModel(
            id = "1",
            mbid = "12",
            name = "Believe",
            artistName = "Cher",
            mediumImageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/3b54885952161aaea4ce2965b2db1638.png",
            largeImageUrl = "https://lastfm.freetls.fastly.net/i/u/174s/3b54885952161aaea4ce2965b2db1638.png",
            isFavorite = true
        ),
        AlbumUiModel(
            id = "2",
            mbid = "23",
            name = "The Very Best of Cher",
            artistName = "Cher",
            mediumImageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/3b54885952161aaea4ce2965b2db1638.png",
            largeImageUrl = "https://lastfm.freetls.fastly.net/i/u/174s/3b54885952161aaea4ce2965b2db1638.png",
            isFavorite = false
        ),
        AlbumUiModel(
            id = "3",
            mbid = "34",
            name = "Heart of Stone",
            artistName = "Cher",
            mediumImageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/3b54885952161aaea4ce2965b2db1638.png",
            largeImageUrl = "https://lastfm.freetls.fastly.net/i/u/174s/3b54885952161aaea4ce2965b2db1638.png",
            isFavorite = false
        ),
        AlbumUiModel(
            id = "4",
            mbid = "45",
            name = "Cher's Greatest Hits: 1965-1992",
            artistName = "Cher",
            mediumImageUrl = "https://lastfm.freetls.fastly.net/i/u/64s/3b54885952161aaea4ce2965b2db1638.png",
            largeImageUrl = "https://lastfm.freetls.fastly.net/i/u/174s/3b54885952161aaea4ce2965b2db1638.png",
            isFavorite = true
        ),
    )
}
