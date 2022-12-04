package com.ms.musicmanagement.shared.model.business.exception

import com.ms.musicmanagement.shared.datasource.backend.constant.BusinessErrorNumber

class UnknownBusinessErrorException(errorMessage: String) : BaseBusinessErrorException(
    errorCode = BusinessErrorNumber.UNKNOWN,
    errorMessage = errorMessage,
)
