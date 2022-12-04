package com.ms.musicmanagement.screen.artistsearch.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ms.musicmanagement.R
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme


@Composable
fun NoArtistFound(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_no_search_result),
            contentDescription = stringResource(id = R.string.image_description_no_search_results)
        )
        Text(
            text = stringResource(id = R.string.artist_search_search_help_text),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun NoArtistFoundPreview() {
    MusicManagementTheme {
        NoArtistFound()
    }
}
