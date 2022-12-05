package com.ms.musicmanagement.screen.savedalbums.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ms.musicmanagement.R
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme


@Composable
fun SavedAlbumsHelpContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.img_disk_album),
            contentDescription = stringResource(
                id = R.string.image_description_disk_image
            )
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(id = R.string.saved_albums_help_text),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun SavedAlbumsHelpContentPreview() {
    MusicManagementTheme {
        SavedAlbumsHelpContent()
    }
}
