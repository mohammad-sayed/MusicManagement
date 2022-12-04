package com.ms.musicmanagement.screen.artisttopalbums

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.ms.musicmanagement.screen.artistsearch.mapper.ArtistSearchMapper
import com.ms.musicmanagement.screen.artistsearch.uimodel.ArtistUiModel
import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCase
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import com.ms.musicmanagement.shared.navigation.ArtistTopAlbumsNavComposableDestination
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArtistTopAlbumsViewModel(
    appContext: Application,
    backStackEntryBundle: Bundle?
) : BaseViewModel(
    appContext = appContext
) {
    private val arguments: ArtistTopAlbumsNavComposableDestination.ArtistTopAlbumsArguments
    val artistName: String

    init {
        arguments = AppNavDestination.ArtistTopAlbums.parseArguments(backStackEntryBundle)
        artistName = arguments.artistName ?: ""
        getTopAlbums()
    }


    private val _topAlbums: MutableStateFlow<List<AlbumUiModel>> = MutableStateFlow(emptyList())
    val topAlbums = _topAlbums.asStateFlow()

    //region Public methods


    fun showAlbumDetails(albumUiModel: AlbumUiModel) {
        //ToDo: Navigate to artist details screen
    }
    //endregion

    //region Private methods
    private fun getTopAlbums() {
        viewModelScope.launch {
            try {
                _showLoading.value = true
                delay(500)
                _topAlbums.value = ArtistTopAlbumsMockData.topAlbums
            } catch (ex: Exception) {
                handleException(ex)
            } finally {
                _showLoading.value = false
            }
        }
    }
    //endregion
}
