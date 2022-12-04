package com.ms.musicmanagement.shared.model.business.exception

import com.ms.musicmanagement.shared.datasource.backend.constant.BusinessErrorNumber

abstract class BaseBusinessErrorException(
    val errorCode: BusinessErrorNumber,
    errorMessage: String
) : Exception(errorMessage)
