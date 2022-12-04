package com.ms.musicmanagement.screen.artistsearch

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.screen.artistsearch.composable.ArtistSearchContent
import com.ms.musicmanagement.shared.ui.composable.BaseScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ArtistSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: ArtistSearchViewModel
) {
    val softKeyboard = LocalSoftwareKeyboardController.current
    BaseScreen(
        viewModel = viewModel,
        content = {
            ArtistSearchContent(
                modifier = modifier.padding(top = 16.dp),
                searchQuery = viewModel.searchQuery.collectAsState().value,
                onSearchQueryChange = viewModel::updateSearchQuery,
                onPerformSearch = {
                    viewModel.performSearch()
                    softKeyboard?.hide()
                },
                artistsList = viewModel.artistsList.collectAsState().value,
                onArtistSelected = viewModel::showArtistDetails
            )
        }
    )

}
