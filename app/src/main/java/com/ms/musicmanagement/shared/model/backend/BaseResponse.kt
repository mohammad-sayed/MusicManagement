package com.ms.musicmanagement.shared.model.backend

import com.google.gson.annotations.SerializedName

abstract class BaseResponse(
    @SerializedName("error")
    val errorCode: Int? = null,
    @SerializedName("message")
    val errorMessage : String? = null
)
