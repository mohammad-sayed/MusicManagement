package com.ms.musicmanagement.shared.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ms.musicmanagement.R
import com.ms.musicmanagement.shared.model.ui.BusinessErrorUiModel
import com.ms.musicmanagement.shared.ui.composable.button.DialogButton

@Composable
internal fun ErrorDialog(
    error: BusinessErrorUiModel?,
    onConfirm: () -> Unit,
) {
    error?.let {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth(),
            onDismissRequest = onConfirm,
            title = { Text(text = error.title) },
            text = { Text(text = error.message) },
            confirmButton = {
                DialogButton(
                    text = stringResource(id = R.string.ok),
                    onClick = onConfirm
                )
            }
        )
    }
}