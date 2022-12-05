package com.ms.musicmanagement.shared.ui.composable.iconbutton

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ms.musicmanagement.R
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun BackIconButton(
    modifier: Modifier = Modifier, onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = stringResource(id = R.string.image_description_search_icon)
            )
        },
        onClick = onClick
    )
}

@Preview
@Composable
private fun BackIconButtonPreview() {
    MusicManagementTheme {
        BackIconButton(onClick = {})
    }
}