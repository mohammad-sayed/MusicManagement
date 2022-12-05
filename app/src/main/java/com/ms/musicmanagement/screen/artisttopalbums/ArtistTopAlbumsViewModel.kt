package com.ms.musicmanagement.screen.artisttopalbums

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums.GetArtistTopAlbumsUseCase
import com.ms.musicmanagement.screen.artisttopalbums.mapper.ArtistTopAlbumsMapper
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.base.NavControllerConsumer
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import com.ms.musicmanagement.shared.navigation.ArtistTopAlbumsNavComposableDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ArtistTopAlbumsViewModel(
    appContext: Application,
    backStackEntryBundle: Bundle?,
    private val getArtistTopAlbumsUseCase: GetArtistTopAlbumsUseCase
) : BaseViewModel(
    appContext = appContext
), NavControllerConsumer {
    private val arguments: ArtistTopAlbumsNavComposableDestination.ArtistTopAlbumsArguments
    val artistName: String

    init {
        arguments = AppNavDestination.ArtistTopAlbums.parseArguments(backStackEntryBundle)
        artistName = arguments.artistName ?: ""
        getTopAlbums()
    }


    private val _topAlbums: MutableStateFlow<List<AlbumUiModel>> = MutableStateFlow(emptyList())
    val topAlbums: StateFlow<List<AlbumUiModel>> = _topAlbums.asStateFlow()

    private var navController: NavController? = null
    //region Public methods


    fun showAlbumDetails(albumUiModel: AlbumUiModel) {
        navController?.navigate(
            route = AppNavDestination.AlbumDetails.getNavigationRoute(
                artistName = artistName,
                albumName = albumUiModel.name
            )
        )
    }

    fun toggleIsFavorite(albumUiModel: AlbumUiModel) {
        val albumIndex = _topAlbums.value.indexOfFirst { it.name == albumUiModel.name }
        if (albumIndex > -1) {
            val mutableList = _topAlbums.value.toMutableList()
            _topAlbums.update {
                val item = it[albumIndex]
                mutableList[albumIndex] = item.copy(isFavorite = !item.isFavorite)
                mutableList
            }
        }
    }

    //region NavControllerConsumer implementation
    override fun updateNavController(navController: NavController) {
        this.navController = navController
    }
    //endregion

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
