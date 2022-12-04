package com.ms.musicmanagement.screen.artistsearch

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ms.musicmanagement.screen.artistsearch.mapper.ArtistSearchMapper
import com.ms.musicmanagement.screen.artistsearch.uimodel.ArtistUiModel
import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCase
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.base.NavControllerConsumer
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArtistSearchViewModel(
    appContext: Application,
    val searchForArtistUseCase: SearchForArtistUseCase
) : BaseViewModel(
    appContext = appContext
), NavControllerConsumer {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _artistsList: MutableStateFlow<List<ArtistUiModel>?> = MutableStateFlow(null)
    val artistsList = _artistsList.asStateFlow()

    var navController: NavController? = null

    //region Public methods
    fun updateSearchQuery(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun performSearch() {
        viewModelScope.launch {
            try {
                _showLoading.value = true
                val artistsDtoList = searchForArtistUseCase(searchQuery = _searchQuery.value)
                _artistsList.value = artistsDtoList.map {
                    ArtistSearchMapper.mapArtistDtoToArtistUiModel(it)
                }
            } catch (ex: Exception) {
                handleException(ex)
            } finally {
                _showLoading.value = false
            }
        }
    }

    fun showArtistDetails(artistUiModel: ArtistUiModel) {
        navController?.navigate(
            route = AppNavDestination.ArtistTopAlbums.getNavigationRoute(
                artistName = artistUiModel.name
            )
        )
    }

    //region NavControllerConsumer implementation
    override fun updateNavController(navController: NavController) {
        this.navController = navController
    }
    //endregion

    //endregion

}
