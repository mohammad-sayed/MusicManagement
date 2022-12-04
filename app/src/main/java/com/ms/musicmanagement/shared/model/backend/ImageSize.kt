package com.ms.musicmanagement.shared.model.backend

import com.google.gson.annotations.SerializedName

enum class ImageSize {

    @SerializedName("small")
    SMALL,

    @SerializedName("medium")
    MEDIUM,

    @SerializedName("large")
    LARGE,

    @SerializedName("extralarge")
    EXTRA_LARGE,

    @SerializedName("mega")
    MEGA

}