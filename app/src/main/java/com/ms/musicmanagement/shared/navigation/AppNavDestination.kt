package com.ms.musicmanagement.shared.navigation

import androidx.navigation.NamedNavArgument

interface NavComposableDestination {
    val navComposableDestination: String
    fun getArguments(): List<NamedNavArgument> = emptyList()
}

object AppNavDestination {

    object SavedAlbums : NavComposableDestination {
        private const val name = "savedalbums"
        override val navComposableDestination = name
        fun getNavigationRoute(): String {
            return name
        }
    }

    object ArtistSearch : NavComposableDestination {
        private const val name = "artistsearch"
        override val navComposableDestination = name
        fun getNavigationRoute(): String {
            return name
        }
    }

    val ArtistTopAlbums = ArtistTopAlbumsNavComposableDestination

    val AlbumDetails = AlbumDetailsNavComposableDestination
}
