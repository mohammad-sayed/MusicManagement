package com.ms.musicmanagement.shared.model.backend.getartisttopalbums

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.Image
import com.ms.musicmanagement.shared.model.backend.searchforartist.Artist

data class Album(
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("image")
    val imageResolutions: List<Image>,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("playcount")
    val playCount: Int,
    @SerializedName("url")
    val url: String
)
