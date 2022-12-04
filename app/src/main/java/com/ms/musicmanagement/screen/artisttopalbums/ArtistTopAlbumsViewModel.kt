package com.ms.musicmanagement.screen.artisttopalbums

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.ms.musicmanagement.screen.artisttopalbums.getartisttopalbums.GetArtistTopAlbumsUseCase
import com.ms.musicmanagement.screen.artisttopalbums.mapper.ArtistTopAlbumsMapper
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import com.ms.musicmanagement.shared.navigation.ArtistTopAlbumsNavComposableDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArtistTopAlbumsViewModel(
    appContext: Application,
    backStackEntryBundle: Bundle?,
    private val getArtistTopAlbumsUseCase: GetArtistTopAlbumsUseCase
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
                val albumsDtoList = getArtistTopAlbumsUseCase.invoke(artistName = artistName)
                _topAlbums.value = albumsDtoList.map {
                    ArtistTopAlbumsMapper.mapAlbumDtoToAlbumUiModel(it)
                }
            } catch (ex: Exception) {
                handleException(ex)
            } finally {
                _showLoading.value = false
            }
        }
    }
    //endregion
}
