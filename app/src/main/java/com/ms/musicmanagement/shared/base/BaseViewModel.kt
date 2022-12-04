package com.ms.musicmanagement.shared.base

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ms.musicmanagement.R
import com.ms.musicmanagement.shared.model.backend.exception.ServerErrorException
import com.ms.musicmanagement.shared.model.ui.BusinessErrorUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.UnknownHostException

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

    /***
     * Handles the common exceptions by updating [BaseViewModel.error] to display the error title
     * and message to the user
     */
    protected fun handleException(exception: Exception) {
        val message: String
        when (exception) {
            is UnknownHostException -> {
                message = appContext.getString(R.string.error_no_internet_connection_message)
            }
            is ServerErrorException -> {
                message = appContext.getString(R.string.error_message_server)
            }
            else -> {
                val exceptionMessage = if (exception.message.isNullOrEmpty()) {
                    appContext.getString(R.string.error_message_unknown)
                } else {
                    exception.message
                }
                message = appContext.getString(
                    R.string.error_message_format,
                    exceptionMessage
                )
            }
        }
        error.value = BusinessErrorUiModel(
            title = appContext.getString(R.string.error_title),
            message = message
        )
    }
}
