package com.ms.musicmanagement.screen.savedalbums.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.screen.savedalbums.SavedAlbumsMockData
import com.ms.musicmanagement.shared.ui.composable.AlbumsListContent
import com.ms.musicmanagement.shared.ui.composable.BaseScreen
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun SavedAlbumsContent(
    albums: List<AlbumUiModel>,
    onAlbumSelected: (AlbumUiModel) -> Unit,
    onToggleIsFavorite: (AlbumUiModel) -> Unit
) {
    if (albums.isEmpty()) {
        SavedAlbumsHelpContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        )
    } else {
        AlbumsListContent(
            albums = albums,
            onAlbumSelected = onAlbumSelected,
            onToggleIsFavorite = onToggleIsFavorite
        )
    }
}

@Preview
@Composable
private fun SavedAlbumsContentPreview() {
    MusicManagementTheme {
        SavedAlbumsContent(
            albums = SavedAlbumsMockData.albums,
            onToggleIsFavorite = {},
            onAlbumSelected = {}
        )
    }
}
