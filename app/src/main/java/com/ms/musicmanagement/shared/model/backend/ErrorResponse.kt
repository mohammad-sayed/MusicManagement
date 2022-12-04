package com.ms.musicmanagement.shared.model.backend

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error")
    val errorCode: Int? = null,
    @SerializedName("message")
    val errorMessage: String? = null
)
