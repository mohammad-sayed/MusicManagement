package com.ms.musicmanagement.screen.artistsearch

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.screen.artistsearch.composable.ArtistSearchContent

@Composable
fun ArtistSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: ArtistSearchViewModel
) {
    ArtistSearchContent(
        modifier = modifier
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp),
        searchQuery = viewModel.searchQuery.collectAsState().value,
        onSearchQueryChange = viewModel::updateSearchQuery,
        onPerformSearch = viewModel::performSearch
    )
}
