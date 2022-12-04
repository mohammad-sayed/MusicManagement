package com.ms.musicmanagement.shared.model.backend.searchforartist

import com.google.gson.annotations.SerializedName

data class Attr(
    @SerializedName("for")
    val searchQuery: String
)
