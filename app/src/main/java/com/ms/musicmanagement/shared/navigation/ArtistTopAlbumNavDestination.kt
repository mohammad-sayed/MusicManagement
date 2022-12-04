package com.ms.musicmanagement.shared.navigation

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.ms.musicmanagement.extension.decodeUrl
import com.ms.musicmanagement.extension.encodeUrl

object ArtistTopAlbumsNavComposableDestination : NavComposableDestination {

    class ArtistTopAlbumsArguments(
        val artistName: String?,
    )

    object ArgumentKeys {
        const val ARTIST_NAME = "artistName"
    }

    private const val name = "artisttopalbums"

    override fun getArguments(): List<NamedNavArgument> = listOf(
        navArgument(name = ArgumentKeys.ARTIST_NAME) {},
    )

    override val navComposableDestination = "$name/{${ArgumentKeys.ARTIST_NAME}}"

    fun getNavigationRoute(artistName: String): String {
        return "$name/${artistName.encodeUrl()}"
    }

    fun parseArguments(arguments: Bundle?): ArtistTopAlbumsArguments {
        return ArtistTopAlbumsArguments(
            artistName = arguments?.getString(ArgumentKeys.ARTIST_NAME)?.decodeUrl(),
        )
    }
}
