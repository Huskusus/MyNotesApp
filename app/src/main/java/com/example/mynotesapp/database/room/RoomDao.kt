package com.example.mynotesapp.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mynotesapp.model.Note


@Dao
interface RoomDao {

    @Query("SELECT * FROM note_table")
    fun getNotes(): LiveData<List<Note>>

    @Insert
    suspend fun createN(note: Note)

    @Update
    suspend fun updateN(note: Note)

    @Delete
    suspend fun deleteN(note: Note)
}