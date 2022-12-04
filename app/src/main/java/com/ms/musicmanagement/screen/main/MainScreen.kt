package com.ms.musicmanagement.screen.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ms.musicmanagement.R
import com.ms.musicmanagement.screen.artistsearch.ArtistSearchScreen
import com.ms.musicmanagement.screen.artistsearch.ArtistSearchViewModel
import com.ms.musicmanagement.screen.artisttopalbums.ArtistTopAlbumsScreen
import com.ms.musicmanagement.screen.artisttopalbums.ArtistTopAlbumsViewModel
import com.ms.musicmanagement.screen.main.composable.PrimaryTopAppBar
import com.ms.musicmanagement.shared.model.ui.TopAppBarProperties
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val mainNavController = rememberAnimatedNavController()

    var topAppBarProperties by remember {
        mutableStateOf(
            TopAppBarProperties(
                title = context.getString(R.string.app_name)
            )
        )
    }

    Scaffold(modifier = modifier, topBar = {
        PrimaryTopAppBar(topAppBarProperties = topAppBarProperties)
    }) {
        AnimatedNavHost(
            navController = mainNavController,
            startDestination = AppNavDestination.ArtistSearch.navComposableDestination
        ) {
            composable(
                route = AppNavDestination.ArtistSearch.navComposableDestination
            ) {
                val viewModel = getViewModel<ArtistSearchViewModel>()
                viewModel.updateNavController(navController = mainNavController)
                topAppBarProperties = TopAppBarProperties(
                    title = stringResource(id = R.string.artist_search_toolbar_title)
                )
                ArtistSearchScreen(
                    viewModel = viewModel
                )
            }
            composable(
                route = AppNavDestination.ArtistTopAlbums.navComposableDestination,
                arguments = AppNavDestination.ArtistTopAlbums.getArguments()
            ) { backStackEntry ->
                val viewModel = getViewModel<ArtistTopAlbumsViewModel>{
                    parametersOf(backStackEntry.arguments)
                }
                topAppBarProperties = TopAppBarProperties(
                    title = stringResource(
                        id = R.string.artist_top_albums_toolbar_title_format,
                        viewModel.artistName
                    )
                )
                ArtistTopAlbumsScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}
