package com.ms.musicmanagement.shared.model.backend.searchforartist

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("@attr")
    val attr: Attr,
    @SerializedName("artistmatches")
    val artistMatches: ArtistMatches,
    @SerializedName("opensearch:Query")
    val openSearchQuery: OpenSearchQuery,
    @SerializedName("opensearch:itemsPerPage")
    val openSearchItemsPerPage: String,
    @SerializedName("opensearch:startIndex")
    val openSearchStartIndex: String,
    @SerializedName("opensearch:totalResults")
    val openSearchTotalResults: String
)
