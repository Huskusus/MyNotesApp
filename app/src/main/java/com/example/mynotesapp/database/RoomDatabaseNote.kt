package com.example.mynotesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotesapp.database.room.RoomDao
import com.example.mynotesapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class RoomDatabaseNote: RoomDatabase() {

    abstract fun getRoomDao(): RoomDao

    companion object{

        @Volatile
        private var INSTANCE: RoomDatabaseNote? = null

        fun getInstance(context: Context): RoomDatabaseNote{
            return if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    RoomDatabaseNote::class.java,
                    "base of notes"
                ).build()
                INSTANCE as RoomDatabaseNote
            } else INSTANCE as RoomDatabaseNote
        }
    }
}