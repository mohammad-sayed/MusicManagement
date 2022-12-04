package com.ms.musicmanagement.shared.navigation

import androidx.navigation.NamedNavArgument

interface NavComposableDestination {
    val navComposableDestination: String
    fun getArguments(): List<NamedNavArgument> = emptyList()
}

interface AppNavRoute {
    val route: String
}

object AppNavDestination {

    object ArtistSearch : NavComposableDestination {
        private const val name = "artistsearch"
        override val navComposableDestination = name
        fun getNavigationRoute() = object : AppNavRoute {
            override val route = name
        }
    }
}
