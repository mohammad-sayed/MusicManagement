package com.ms.musicmanagement.shared.model.backend.searchforartist

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.Image

data class Artist(
    @SerializedName("image")
    val imageResolutions: List<Image>? = null,
    @SerializedName("listeners")
    val listeners: String? = null,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: String? = null,
    @SerializedName("url")
    val url: String
)
