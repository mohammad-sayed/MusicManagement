package com.ms.musicmanagement.screen.artistsearch

import android.app.Application
import com.ms.musicmanagement.shared.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArtistSearchViewModel(
    appContext: Application,
) : BaseViewModel(
    appContext = appContext
) {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    //region Public methods
    fun updateSearchQuery(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun performSearch() {
        //ToDo: Perform Search
    }
    //endregion
}
