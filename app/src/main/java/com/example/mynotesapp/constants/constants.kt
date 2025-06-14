package com.example.mynotesapp.constants

import com.example.mynotesapp.database.DataBaseRep

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DataBaseRep



object Constants{
    object Keys{
        const val BASE_OF_NOTE = "base of notes"
        const val NOTE_TABLE = "note_table"
        const val ADD_NOTE = "Addition note"
        const val CREATE_NOTE = "Create new note"
        const val ROOM_DATABASE = "Offline enter"
        const val ACCOUNT = "Authorization"
        const val ID = "id"
        const val NONE = "none"
    }
    object Screens{
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val NOTE_SCREEN = "notes_screen"
        const val CREATE_SCREEN = "creating_screen"
    }
}
