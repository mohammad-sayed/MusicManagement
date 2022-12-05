package com.ms.musicmanagement.screen.albumdetails.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.R
import com.ms.musicmanagement.screen.albumdetails.AlbumDetailsMockData
import com.ms.musicmanagement.screen.albumdetails.uimodel.AlbumDetailsUiModel
import com.ms.musicmanagement.shared.model.ui.ArtistUiModel
import com.ms.musicmanagement.shared.ui.composable.CoilImage
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun AlbumsDetailsContent(
    modifier: Modifier = Modifier,
    album: AlbumDetailsUiModel?
) {
    LazyColumn(modifier = modifier) {
        item {
            AlbumImage(album = album ?: return@item)
        }
        item {
            Text(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp),
                text = album?.name ?: return@item,
                style = MaterialTheme.typography.h4,
            )
        }
        item {
            Text(
                text = album?.artistName ?: "",
                style = MaterialTheme.typography.subtitle1,
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 16.dp),
                text = stringResource(id = R.string.album_details_tracks_title),
                style = MaterialTheme.typography.h6,
            )
        }
        album?.tracks?.forEach { track ->
            item(key = track) {
                TrackItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(all = 16.dp),
                    track = track
                )
                Divider()
            }
        }
    }
}

@Composable
private fun AlbumImage(
    modifier: Modifier = Modifier,
    album: AlbumDetailsUiModel
) {
    CoilImage(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(ratio = 1f),
        imageUrl = album.largeImageUrl,
        contentDescription = stringResource(
            id = R.string.image_description_album_image_format,
            album.name
        )
    )
}

@Composable
private fun TrackItem(
    modifier: Modifier = Modifier,
    track: String,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = track,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
private fun AlbumsDetailsContentPreview() {
    MusicManagementTheme {
        AlbumsDetailsContent(
            album = AlbumDetailsMockData.albumDetails,
        )
    }
}
