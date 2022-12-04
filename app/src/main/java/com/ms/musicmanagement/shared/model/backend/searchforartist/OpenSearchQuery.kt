package com.ms.musicmanagement.shared.model.backend.searchforartist

import com.google.gson.annotations.SerializedName

data class OpenSearchQuery(
    @SerializedName("#text")
    val text: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("searchTerms")
    val searchTerms: String,
    @SerializedName("startPage")
    val startPage: String
)
