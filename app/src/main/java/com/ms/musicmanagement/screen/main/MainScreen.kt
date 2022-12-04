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
import com.ms.musicmanagement.screen.main.composable.PrimaryTopAppBar
import com.ms.musicmanagement.shared.model.ui.TopAppBarProperties
import com.ms.musicmanagement.shared.navigation.AppNavDestination

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
                topAppBarProperties = TopAppBarProperties(
                    title = stringResource(id = R.string.artist_search_toolbar_title)
                )
                Text("Artist Search")
            }
        }
    }
}