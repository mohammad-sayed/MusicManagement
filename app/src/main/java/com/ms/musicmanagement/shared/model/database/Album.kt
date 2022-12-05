package com.ms.musicmanagement.shared.model.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DatabaseTable.Album.TABLE_NAME)
data class Album(
    @PrimaryKey val id: String,
    @NonNull @ColumnInfo(name = DatabaseTable.Album.NAME) val name: String,
    @NonNull @ColumnInfo(name = DatabaseTable.Album.ARTIST_NAME) val artistName: String,
    @ColumnInfo(name = DatabaseTable.Album.MBID) val mbid: String?,
    @ColumnInfo(name = DatabaseTable.Album.TRACKS) val tracks: List<String>,
    @ColumnInfo(name = DatabaseTable.Album.IMAGE_MEDIUM) val largeImageUrl: String?,
    @ColumnInfo(name = DatabaseTable.Album.IMAGE_LARGE) val mediumImageUrl: String?
)
