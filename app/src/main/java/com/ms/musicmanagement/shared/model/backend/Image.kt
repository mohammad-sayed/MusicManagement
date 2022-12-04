package com.ms.musicmanagement.shared.model.backend

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text")
    val url: String,
    @SerializedName("size")
    val size: ImageSize
)
