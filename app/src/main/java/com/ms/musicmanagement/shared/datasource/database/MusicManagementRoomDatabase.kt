package com.ms.musicmanagement.shared.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ms.musicmanagement.shared.model.database.Album
import com.ms.musicmanagement.shared.model.database.DatabaseConverter
import com.ms.musicmanagement.shared.model.database.DatabaseTable
import com.ms.musicmanagement.shared.model.database.dao.AlbumDao

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(
    entities = [Album::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConverter::class)
abstract class MusicManagementRoomDatabase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MusicManagementRoomDatabase? = null

        fun getDatabase(context: Context): MusicManagementRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MusicManagementRoomDatabase::class.java,
                    "music_management_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
