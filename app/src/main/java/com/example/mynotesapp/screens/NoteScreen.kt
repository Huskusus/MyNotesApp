package com.example.mynotesapp.screens

import android.app.Application
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mynotesapp.MainViewModel
import com.example.mynotesapp.MainViewModelFactory
import com.example.mynotesapp.NavRoute
import com.example.mynotesapp.constants.Constants.Keys.NONE
import com.example.mynotesapp.model.Note
import com.example.mynotesapp.ui.theme.MyNotesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(navController: NavHostController, viewModel: MainViewModel, noteId: String?){
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value
    val note = notes.firstOrNull{it.id == noteId?.toInt()} ?: Note(title = NONE, subtitle = NONE)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {paddingValue ->
            Box(
                modifier = Modifier.padding(paddingValue),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top) {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(note.title, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp))
                            Text(note.subtitle, fontSize = 14.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(top = 10.dp))
                        }
                    }
                    Button(modifier =
                        Modifier.fillMaxWidth(),

                        onClick = {
                            viewModel.deleteNote(note=note) {
                                navController.navigate(NavRoute.MainScreen.route)
                            }
                        }
                    )
                    {
                        Text(text="Delete")
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ReviewNote(){
    MyNotesAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        NoteScreen(navController = rememberNavController(), viewModel = mViewModel, noteId = "1")
    }
}
