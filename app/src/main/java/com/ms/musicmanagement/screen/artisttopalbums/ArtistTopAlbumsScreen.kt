package com.ms.musicmanagement.screen.artisttopalbums

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.shared.ui.composable.AlbumsListContent
import com.ms.musicmanagement.shared.ui.composable.BaseScreen

@Composable
fun ArtistTopAlbumsScreen(
    modifier: Modifier = Modifier,
    viewModel: ArtistTopAlbumsViewModel
) {
    BaseScreen(
        viewModel = viewModel,
        content = {
            AlbumsListContent(
                modifier = modifier.padding(top = 16.dp),
                albums = viewModel.topAlbums.collectAsState().value,
                onAlbumSelected = viewModel::showAlbumDetails,
                onToggleIsFavorite = viewModel::toggleIsFavorite
            )
        }
    )
}
