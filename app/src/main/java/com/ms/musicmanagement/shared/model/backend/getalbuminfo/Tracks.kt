package com.ms.musicmanagement.shared.model.backend.getalbuminfo

import com.google.gson.annotations.SerializedName

data class Tracks(
    @SerializedName("track")
    val tracksList: List<Track>
)