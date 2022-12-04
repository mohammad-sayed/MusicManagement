package com.ms.musicmanagement.screen.artistsearch.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun ArtistSearchContent(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onPerformSearch: () -> Unit,
) {
    Column(modifier = modifier) {
        SearchField(
            searchQuery = searchQuery,
            onSearchQueryChange = onSearchQueryChange,
            onPerformSearch = onPerformSearch
        )
    }
}

@Preview
@Composable
fun ArtistsSearchContentPreview(
    modifier: Modifier = Modifier,
) {
    MusicManagementTheme {
        val (query, onQueryChanged) = remember { mutableStateOf("") }
        ArtistSearchContent(
            searchQuery = query,
            onSearchQueryChange = onQueryChanged,
            onPerformSearch = {}
        )
    }
}
