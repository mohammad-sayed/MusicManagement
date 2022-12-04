package com.ms.musicmanagement.shared.model.backend.exception

import com.ms.musicmanagement.shared.datasource.backend.constant.BackendErrorCode

class BackendBusinessException(
    errorCode: Int,
    errorMessage: String
) : RuntimeException(errorMessage) {
    val backendBusinessErrorCode = BackendErrorCode.fromValue(errorCode) ?: BackendErrorCode.UNKNOWN
}
