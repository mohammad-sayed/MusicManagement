package com.ms.musicmanagement.screen.artisttopalbums.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.R
import com.ms.musicmanagement.screen.artisttopalbums.ArtistTopAlbumsMockData
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.ui.composable.CoilImage
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun ArtistTopAlbumsContent(
    modifier: Modifier = Modifier,
    albums: List<AlbumUiModel>,
    onItemSelected: (AlbumUiModel) -> Unit
) {
    LazyColumn(modifier = modifier) {
        albums.forEach { album ->
            item(key = album.id) {
                AlbumItem(
                    modifier = Modifier
                        .clickable { onItemSelected(album) }
                        .padding(all = 16.dp),
                    album = album
                )
                Divider()
            }
        }
    }
}

@Composable
private fun AlbumItem(
    modifier: Modifier = Modifier,
    album: AlbumUiModel
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            modifier = Modifier.size(100.dp),
            imageUrl = album.mediumImageUrl,
            contentDescription = stringResource(
                id = R.string.image_description_album_image_format,
                album.name
            )
        )
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = album.name,
        )
    }
}


@Preview
@Composable
private fun ArtistTopAlbumsContentPreview() {
    MusicManagementTheme {
        ArtistTopAlbumsContent(
            albums = ArtistTopAlbumsMockData.topAlbums,
            onItemSelected = {}
        )
    }
}