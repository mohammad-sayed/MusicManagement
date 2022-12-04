package com.ms.musicmanagement.screen.albumdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.screen.albumdetails.composable.AlbumsDetailsContent
import com.ms.musicmanagement.shared.ui.composable.BaseScreen

@Composable
fun AlbumDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: AlbumDetailsViewModel
) {
    BaseScreen(
        viewModel = viewModel,
        content = {
            AlbumsDetailsContent(
                modifier = modifier.padding(top = 16.dp),
                album = viewModel.album.collectAsState().value,
            )
        }
    )
}
