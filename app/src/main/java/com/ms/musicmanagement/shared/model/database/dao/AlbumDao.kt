package com.ms.musicmanagement.shared.model.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ms.musicmanagement.shared.model.database.Album
import com.ms.musicmanagement.shared.model.database.DatabaseTable
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {

    @Query("SELECT * FROM ${DatabaseTable.Album.TABLE_NAME}")
    fun getAllAlbums(): Flow<List<Album>>

    @Query("SELECT * FROM ${DatabaseTable.Album.TABLE_NAME} WHERE ${DatabaseTable.Album.NAME}=:albumName")
    fun getAlbumById(albumName: String): List<Album>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(album: Album)

    @Query("DELETE FROM ${DatabaseTable.Album.TABLE_NAME} WHERE ${DatabaseTable.Album.NAME}=:albumName")
    suspend fun deleteAlbumById(albumName: String)
}
