package com.ms.musicmanagement.screen.savedalbums

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.ui.composable.AlbumsListContent
import com.ms.musicmanagement.shared.ui.composable.BaseScreen

@Composable
fun SavedAlbumsScreen(
    viewModel: SavedAlbumsViewModel
) {
    BaseScreen(
        viewModel = viewModel,
        content = {
            AlbumsListContent(
                albums = viewModel.albums.collectAsState().value,
                onAlbumSelected = viewModel::showAlbumDetails,
                onToggleIsFavorite = viewModel::toggleIsFavorite
            )
        }
    )
}
