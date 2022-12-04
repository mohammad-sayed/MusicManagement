package com.ms.musicmanagement.screen.artistsearch.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ms.musicmanagement.R
import com.ms.musicmanagement.shared.ui.theme.MusicManagementTheme


@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onPerformSearch: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.weight(1f),
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            singleLine = true
        )
        SearchIconButton(onClick = onPerformSearch)
    }
}

@Composable
private fun SearchIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.image_description_search_icon)
            )
        },
        onClick = onClick
    )
}

@Preview
@Composable
fun SearchFieldPreview() {
    MusicManagementTheme {
        val (query, onQueryChanged) = remember { mutableStateOf("") }
        SearchField(
            searchQuery = query,
            onSearchQueryChange = onQueryChanged,
            onPerformSearch = {}
        )
    }
}
