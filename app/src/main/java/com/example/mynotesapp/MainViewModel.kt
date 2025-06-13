package com.example.mynotesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mynotesapp.constants.REPOSITORY
import com.example.mynotesapp.constants.TYPE_ROOM
import com.example.mynotesapp.database.RoomDatabaseNote
import com.example.mynotesapp.database.RoomRepository

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
    }


class MainViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application= application) as T
        }
        throw kotlin.IllegalArgumentException("Unknown VM class")
    }
}
