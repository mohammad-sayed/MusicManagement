package com.ms.musicmanagement.screen.artistsearch

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.ms.musicmanagement.screen.artistsearch.uimodel.ArtistUiModel
import com.ms.musicmanagement.shared.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArtistSearchViewModel(
    appContext: Application,
) : BaseViewModel(
    appContext = appContext
) {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _artistsList: MutableStateFlow<List<ArtistUiModel>?> = MutableStateFlow(null)
    val artistsList = _artistsList.asStateFlow()

    //region Public methods
    fun updateSearchQuery(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun performSearch() {
        viewModelScope.launch {
            //ToDo: Use real data
            delay(1000)
            _artistsList.value = if (_searchQuery.value.isBlank()) {
                emptyList()
            } else {
                ArtistSearchMockData.artistsList.filter { it.name.contains(_searchQuery.value) }
            }

        }
    }

    fun showArtistDetails(artistUiModel: ArtistUiModel) {
        //ToDo: Navigate to artist details screen
    }
    //endregion
}
