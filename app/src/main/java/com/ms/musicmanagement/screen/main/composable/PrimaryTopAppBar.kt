package com.ms.musicmanagement.screen.main.composable

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ms.musicmanagement.R
import com.ms.musicmanagement.shared.model.ui.TopAppBarProperties
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme

@Composable
fun PrimaryTopAppBar(
    modifier: Modifier = Modifier,
    topAppBarProperties: TopAppBarProperties,
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = topAppBarProperties.navigationIcon,
        title = {
            Text(text = topAppBarProperties.title)
        },
        actions = topAppBarProperties.actions
    )
}

@Preview
@Composable
private fun PrimaryTopAppBarPreview() {
    MusicManagementTheme {
        PrimaryTopAppBar(
            topAppBarProperties = TopAppBarProperties(
                title = stringResource(id = R.string.app_name)
            )
        )
    }
}
