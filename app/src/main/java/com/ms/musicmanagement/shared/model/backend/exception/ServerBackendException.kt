package com.ms.musicmanagement.shared.model.backend.exception

class ServerBackendException(
    val errorCode: Int,
    errorMessage: String
) : RuntimeException(errorMessage)
