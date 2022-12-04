package com.ms.musicmanagement.screen.artistsearch.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.screen.artistsearch.ArtistSearchMockData
import com.ms.musicmanagement.screen.artistsearch.uimodel.ArtistUiModel
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun ArtistSearchContent(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onPerformSearch: () -> Unit,
    artistsList: List<ArtistUiModel>?,
    onArtistSelected: (ArtistUiModel) -> Unit,
    showResultsList: Boolean
) {
    Column(modifier = modifier) {
        SearchField(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(horizontal = 16.dp),
            searchQuery = searchQuery,
            onSearchQueryChange = onSearchQueryChange,
            onPerformSearch = onPerformSearch
        )
        if (showResultsList) {
            if (artistsList == null) {
                ArtistSearchHelpContent(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                )
            } else if (artistsList.isEmpty()) {
                NoArtistFound(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                )
            } else {
                ArtistsListContent(
                    modifier = Modifier.weight(1f),
                    artistsList = artistsList,
                    onItemSelected = onArtistSelected
                )
            }
        }
    }
}

@Preview
@Composable
fun ArtistsSearchContentPreview() {
    MusicManagementTheme {
        val (query, onQueryChanged) = remember { mutableStateOf("") }
        ArtistSearchContent(
            searchQuery = query,
            onSearchQueryChange = onQueryChanged,
            onPerformSearch = {},
            artistsList = ArtistSearchMockData.artistsList,
            onArtistSelected = {},
            showResultsList = false
        )
    }
}
