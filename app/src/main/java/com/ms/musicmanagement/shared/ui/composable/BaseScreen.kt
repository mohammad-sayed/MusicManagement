package com.ms.musicmanagement.shared.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.ms.musicmanagement.shared.base.BaseViewModel

@Composable
fun BaseScreen(
    viewModel: BaseViewModel,
    content: @Composable () -> Unit,
) {
    content()
    ErrorDialog(
        error = viewModel.generalError.collectAsState().value,
        onConfirm = {
            viewModel.resetGeneralError()
        }
    )
    if (viewModel.showLoading.collectAsState().value) {
        LoadingProgress()
    }
}
