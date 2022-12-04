package com.ms.musicmanagement.shared.model.backend.exception

import com.ms.musicmanagement.shared.datasource.backend.constant.BackendErrorCode

class UnknownBackendException(
    val errorCode: Int,
    message: String
) : RuntimeException(message)
