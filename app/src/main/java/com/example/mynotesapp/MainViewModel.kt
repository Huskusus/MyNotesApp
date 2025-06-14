package com.example.mynotesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mynotesapp.constants.REPOSITORY
import com.example.mynotesapp.constants.TYPE_ROOM
import com.example.mynotesapp.database.RoomDatabaseNote
import com.example.mynotesapp.database.RoomRepository
import com.example.mynotesapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit){
        Log.d("checkData", "MainViewModel init dataBase $type")
        when(type){
            TYPE_ROOM -> {
                val dao = RoomDatabaseNote.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
            }
        }
    fun addNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(note=note) {
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }
    fun readAllNotes() = REPOSITORY.readData

    fun deleteNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(note = note){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }

    }

class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application= application) as T
        }
        throw kotlin.IllegalArgumentException("Unknown VM class")
    }
}
