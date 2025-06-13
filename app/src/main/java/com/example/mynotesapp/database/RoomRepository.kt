package com.example.mynotesapp.database

import androidx.lifecycle.LiveData
import com.example.mynotesapp.database.room.RoomDao
import com.example.mynotesapp.model.Note

class RoomRepository(private val noteDao: RoomDao): DataBaseRep {
    override val readData: LiveData<List<Note>>
        get() = noteDao.getNotes()

    override suspend fun create(
        note: Note,
        Process: () -> Unit
    ) {
        noteDao.createN(note = note)
    }

    override suspend fun update(
        note: Note,
        Process: () -> Unit
    ) {
        noteDao.updateN(note=note)
    }

    override suspend fun delete(
        note: Note,
        Process: () -> Unit
    ) {
        noteDao.deleteN(note=note)
    }

}