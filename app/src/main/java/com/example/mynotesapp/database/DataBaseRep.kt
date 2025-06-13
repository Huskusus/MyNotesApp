package com.example.mynotesapp.database

import androidx.lifecycle.LiveData
import com.example.mynotesapp.model.Note

interface DataBaseRep {

    val readData: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: () -> Unit)

    suspend fun update(note: Note, onSuccess: () -> Unit)

    suspend fun delete(note: Note, onSuccess: () -> Unit)

}