package com.example.mynotesapp.database

import androidx.lifecycle.LiveData
import com.example.mynotesapp.model.Note

interface DataBaseRep {

    val readData: LiveData<List<Note>>

    suspend fun create(note: Note, Process: () -> Unit)

    suspend fun update(note: Note, Process: () -> Unit)

    suspend fun delete(note: Note, Process: () -> Unit)

}