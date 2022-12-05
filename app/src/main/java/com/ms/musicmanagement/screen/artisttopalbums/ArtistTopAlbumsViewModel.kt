package com.ms.musicmanagement.screen.artisttopalbums

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ms.musicmanagement.screen.albumdetails.mapper.AlbumDetailsMapper
import com.ms.musicmanagement.screen.albumdetails.usecase.getalbuminfo.GetAlbumInfoUseCase
import com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums.GetArtistTopAlbumsUseCase
import com.ms.musicmanagement.screen.artisttopalbums.mapper.ArtistTopAlbumsMapper
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.base.NavControllerConsumer
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import com.ms.musicmanagement.shared.navigation.ArtistTopAlbumsNavComposableDestination
import com.ms.musicmanagement.shared.usecase.cachealbum.CacheAlbumUseCase
import com.ms.musicmanagement.shared.usecase.deletecachedalbum.DeleteAlbumUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ArtistTopAlbumsViewModel(
    appContext: Application,
    backStackEntryBundle: Bundle?,
    private val getArtistTopAlbumsUseCase: GetArtistTopAlbumsUseCase,
    private val getAlbumInfoUseCase: GetAlbumInfoUseCase,
    private val cacheAlbumUseCase: CacheAlbumUseCase,
    private val deleteAlbumUseCase: DeleteAlbumUseCase
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
    val topAlbums = _topAlbums.asStateFlow()

    private var navController: NavController? = null
    private var albumDtoList: List<AlbumDto> = emptyList()
    //region Public methods


    fun showAlbumDetails(albumUiModel: AlbumUiModel) {
        navController?.navigate(
            route = AppNavDestination.AlbumDetails.getNavigationRoute(
                artistName = albumUiModel.artistName,
                albumName = albumUiModel.name
            )
        )
    }

    fun toggleIsFavorite(albumUiModel: AlbumUiModel) {
        viewModelScope.launch {
            val albumIndex = _topAlbums.value.indexOfFirst { it.name == albumUiModel.name }
            if (albumIndex > -1) {
                val item = _topAlbums.value[albumIndex]
                val newIsFavorite = !item.isFavorite
                val isUpdated = if (newIsFavorite) {
                    cacheAlbum(albumIndex)
                } else {
                    deleteAlbum(albumUiModel.name)
                }
                if (isUpdated) {
                    val mutableList = _topAlbums.value.toMutableList()
                    _topAlbums.update {
                        mutableList[albumIndex] = item.copy(isFavorite = newIsFavorite)
                        mutableList
                    }
                }
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
                albumDtoList = getArtistTopAlbumsUseCase(artistName = artistName)
                _topAlbums.value = albumDtoList.map {
                    ArtistTopAlbumsMapper.mapAlbumDtoToAlbumUiModel(it)
                }
            } catch (ex: Exception) {
                handleException(ex)
            } finally {
                _showLoading.value = false
            }
        }
    }

    private suspend fun getAlbumsInfo(albumName: String, artistName: String): AlbumDto? {
        try {
            return getAlbumInfoUseCase(
                artistName = artistName,
                albumName = albumName
            )
        } catch (ex: Exception) {
            handleException(ex)
            return null
        }
    }

    private suspend fun cacheAlbum(albumIndex: Int): Boolean {
        val album = albumDtoList[albumIndex]
        val albumDtoWithTracks =
            getAlbumsInfo(artistName = album.artistName, albumName = album.name)
        return try {
            albumDtoWithTracks?.let {
                cacheAlbumUseCase(albumDtoWithTracks)
                true
            } ?: false
        } catch (ex: Exception) {
            false
        }
    }

    private suspend fun deleteAlbum(albumName: String): Boolean {
        return try {
            deleteAlbumUseCase(albumName = albumName)
            true
        } catch (ex: Exception) {
            false
        }
    }
    //endregion
}
