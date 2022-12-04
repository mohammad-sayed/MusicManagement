package com.ms.musicmanagement.shared.model.backend.searchforartist

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.Image

data class Artist(
    @SerializedName("image")
    val imageResolutions: List<Image>,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("url")
    val url: String
)
