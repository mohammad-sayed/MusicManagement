package com.ms.musicmanagement.shared.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.R
import com.ms.musicmanagement.screen.artisttopalbums.ArtistTopAlbumsMockData
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun AlbumsListContent(
    modifier: Modifier = Modifier,
    albums: List<AlbumUiModel>,
    onAlbumSelected: (AlbumUiModel) -> Unit,
    onToggleIsFavorite: (AlbumUiModel) -> Unit
) {
    LazyColumn(modifier = modifier) {
        albums.forEach { album ->
            item(key = album.id) {
                AlbumItem(
                    modifier = Modifier
                        .clickable { onAlbumSelected(album) }
                        .padding(all = 16.dp),
                    album = album,
                    onToggleIsFavorite = { onToggleIsFavorite(album) }
                )
                Divider()
            }
        }
    }
}

@Composable
private fun AlbumItem(
    modifier: Modifier = Modifier,
    album: AlbumUiModel,
    onToggleIsFavorite: () -> Unit
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
                .padding(
                    end = 16.dp,
                    start = 16.dp
                )
                .weight(1f),
            text = album.name,
        )
        FavoriteIconButton(
            modifier = Modifier.padding(16.dp),
            isFavorite = album.isFavorite,
            onClick = onToggleIsFavorite
        )
    }
}

@Composable
private fun FavoriteIconButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    val drawableResId = if (isFavorite) {
        R.drawable.ic_favorite
    } else {
        R.drawable.ic_unfavorite
    }
    IconButton(
        modifier = modifier,
        content = {
            Icon(
                painter = painterResource(id = drawableResId),
                contentDescription = stringResource(id = R.string.image_description_search_icon)
            )
        },
        onClick = onClick
    )
}


@Preview
@Composable
private fun ArtistTopAlbumsContentPreview() {
    MusicManagementTheme {
        AlbumsListContent(
            albums = ArtistTopAlbumsMockData.topAlbums,
            onAlbumSelected = {},
            onToggleIsFavorite = {}
        )
    }
}