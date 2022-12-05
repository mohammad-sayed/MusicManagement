package com.ms.musicmanagement.shared.model.database

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DatabaseConverter {
    @TypeConverter
    fun fromList(value: List<String>): String {
        val json = Gson().toJson(value)
        Log.i("DatabaseConverter", "json: $json")
        return json
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        val list = Gson().fromJson<List<String>>(value, listType)
        Log.i("DatabaseConverter", "list: $list")
        return list
    }
}
