package com.ms.musicmanagement.shared.model.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

data class TopAppBarProperties(
    val navigationIcon: @Composable (() -> Unit)? = null,
    val title: String,
    val actions: @Composable RowScope.() -> Unit = {},
)
