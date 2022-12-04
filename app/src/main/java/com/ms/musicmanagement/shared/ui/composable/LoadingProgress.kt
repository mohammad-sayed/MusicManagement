package com.ms.musicmanagement.shared.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun LoadingProgress(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Preview
@Composable
fun GeneralLoadingPreview() {
    MusicManagementTheme {
        LoadingProgress()
    }
}
