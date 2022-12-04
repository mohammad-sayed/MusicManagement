package com.ms.musicmanagement.screen.artistsearch.composable

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
import com.ms.musicmanagement.screen.artistsearch.ArtistSearchMockData
import com.ms.musicmanagement.screen.artistsearch.uimodel.ArtistUiModel
import com.ms.musicmanagement.shared.ui.composable.CoilImage
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme


@Composable
fun ArtistsListContent(
    modifier: Modifier = Modifier,
    artistsList: List<ArtistUiModel>,
    onItemSelected: (ArtistUiModel) -> Unit
) {
    LazyColumn(modifier = modifier) {
        artistsList.forEach { artist ->
            item(key = artist.id) {
                ArtistItem(
                    modifier = Modifier
                        .clickable { onItemSelected(artist) }
                        .padding(all = 16.dp),
                    artist = artist
                )
                Divider()
            }
        }
    }
}

@Composable
private fun ArtistItem(
    modifier: Modifier = Modifier,
    artist: ArtistUiModel
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            modifier = Modifier.size(100.dp),
            imageUrl = artist.imageUrl,
            contentDescription = stringResource(
                id = R.string.image_description_artist_image_format,
                artist.name
            )
        )
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = artist.name,
        )
    }
}

@Preview
@Composable
private fun ArtistsListContentPreview() {
    MusicManagementTheme {
        ArtistsListContent(
            artistsList = ArtistSearchMockData.artistsList,
            onItemSelected = {}
        )
    }
}
