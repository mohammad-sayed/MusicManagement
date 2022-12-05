package com.ms.musicmanagement.shared.model.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DatabaseConverter {
    @TypeConverter
    fun fromList(value: List<String>) = Gson().toJson(value)

    @TypeConverter
    fun toList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
}
