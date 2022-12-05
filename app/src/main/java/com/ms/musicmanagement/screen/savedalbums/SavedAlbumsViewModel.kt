package com.ms.musicmanagement.screen.savedalbums

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums.GetArtistTopAlbumsUseCase
import com.ms.musicmanagement.screen.artisttopalbums.mapper.ArtistTopAlbumsMapper
import com.ms.musicmanagement.screen.artisttopalbums.uimodel.AlbumUiModel
import com.ms.musicmanagement.screen.savedalbums.usecase.getcachedalbums.GetCachedAlbumsUseCase
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.base.NavControllerConsumer
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import com.ms.musicmanagement.shared.usecase.cachealbum.CacheAlbumUseCase
import com.ms.musicmanagement.shared.usecase.deletecachedalbum.DeleteAlbumUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SavedAlbumsViewModel(
    appContext: Application,
    private val getArtistTopAlbumsUseCase: GetArtistTopAlbumsUseCase,
    private val getCachedAlbumsUseCase: GetCachedAlbumsUseCase,
    private val cacheAlbumUseCase: CacheAlbumUseCase,
    private val deleteAlbumUseCase: DeleteAlbumUseCase
) : BaseViewModel(
    appContext = appContext
), NavControllerConsumer {
    init {
        getCachedAlbums()
    }

    private val _albums: MutableStateFlow<List<AlbumUiModel>> = MutableStateFlow(emptyList())
    val albums = _albums.asStateFlow()

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
            val albumIndex = _albums.value.indexOfFirst { it.name == albumUiModel.name }
            if (albumIndex > -1) {
                val item = _albums.value[albumIndex]
                val newIsFavorite = !item.isFavorite
                val isUpdated = if (newIsFavorite) {
                    cacheAlbum(albumIndex)
                } else {
                    deleteAlbum(albumUiModel.name)
                }
                if (isUpdated) {
                    val mutableList = _albums.value.toMutableList()
                    _albums.update {
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
    private fun getCachedAlbums() {
        viewModelScope.launch {
            getCachedAlbumsUseCase().collect { albumsDtoList ->
                _albums.value = albumsDtoList.map { albumDto ->
                    ArtistTopAlbumsMapper.mapAlbumDtoToAlbumUiModel(albumDto)
                }
            }
        }
    }

    private suspend fun cacheAlbum(albumIndex: Int): Boolean {
        return try {
            cacheAlbumUseCase(albumDtoList[albumIndex])
            true
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
