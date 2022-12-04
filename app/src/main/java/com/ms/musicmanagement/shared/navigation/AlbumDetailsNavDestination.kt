package com.ms.musicmanagement.shared.navigation

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.ms.musicmanagement.extension.decodeUrl
import com.ms.musicmanagement.extension.encodeUrl

object AlbumDetailsNavComposableDestination : NavComposableDestination {

    class AlbumDetailsArguments(
        val artistName: String?,
        val albumName: String?,
    )

    object ArgumentKeys {
        const val ARTIST_NAME = "artistName"
        const val ALBUM_NAME = "albumName"
    }

    private const val name = "albums"

    override fun getArguments(): List<NamedNavArgument> = listOf(
        navArgument(name = ArgumentKeys.ARTIST_NAME) {},
        navArgument(name = ArgumentKeys.ALBUM_NAME) {},
    )

    override val navComposableDestination = name +
            "/{${ArgumentKeys.ARTIST_NAME}}" +
            "/{${ArgumentKeys.ALBUM_NAME}}"

    fun getNavigationRoute(
        artistName: String,
        albumName: String
    ): String {
        return name +
                "/${artistName.encodeUrl()}" +
                "/${albumName.encodeUrl()}"
    }

    fun parseArguments(arguments: Bundle?): AlbumDetailsArguments {
        return AlbumDetailsArguments(
            artistName = arguments?.getString(ArgumentKeys.ARTIST_NAME)?.decodeUrl(),
            albumName = arguments?.getString(ArgumentKeys.ALBUM_NAME)?.decodeUrl(),
        )
    }
}
