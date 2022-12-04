package com.ms.musicmanagement.shared.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ms.musicmanagement.R

@Composable
fun CoilImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    contentDescription: String?
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_error)
            .build(),
        contentDescription = contentDescription
    )
}
