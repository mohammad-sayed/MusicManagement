package com.ms.musicmanagement.shared.base

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ms.musicmanagement.shared.model.ui.BusinessErrorUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel(
    protected val appContext: Application,
) : ViewModel() {

    /***
     * Error state should be collected in composable and display its [BusinessErrorUiModel.title] and
     * [BusinessErrorUiModel.message] in a user friendly context like dialogs.
     */
    protected val error = MutableStateFlow<BusinessErrorUiModel?>(null)
    val generalError = error.asStateFlow()

    protected val _showLoading = MutableStateFlow(false)
    val showLoading = _showLoading.asStateFlow()

    fun resetGeneralError() {
        error.value = null
    }
}
