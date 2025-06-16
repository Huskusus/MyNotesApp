package com.example.mynotesapp.screens

import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    @Composable
    fun getStrictValidNote(noteId: String?, notes: List<Note>): Note? {
        return remember(noteId, notes) {
            noteId?.toIntOrNull()?.let { id ->
                notes.firstOrNull { it.id == id }?.takeIf {
                    it.title.isNotEmpty() && it.subtitle.isNotEmpty()
                }
            }
        }
    }
    val currentNote = getStrictValidNote(noteId, notes) ?: return

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
                            var title1 by remember { mutableStateOf(currentNote.title) }
                            //Text(note.title, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp))
                            TextField(
                                value = title1,
                                onValueChange = {title1 = it},
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(textAlign = TextAlign.Center, color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            )

                            Column(
                                modifier = Modifier.fillMaxSize()) {
                                var subtitle1 by remember { mutableStateOf(currentNote.subtitle) }
                                TextField(
                                    value = subtitle1,
                                    onValueChange = { subtitle1 = it },
                                    modifier = Modifier.fillMaxWidth().size(width = 400.dp, height = 650.dp),
                                    maxLines = Int.MAX_VALUE,
                                    colors = TextFieldDefaults.colors(
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent
                                    ),
                                    textStyle = TextStyle(fontSize = 14.sp)
                                    )
                                Row(
                                    verticalAlignment = Alignment.Bottom,
                                    horizontalArrangement = Arrangement.Center
                                ){
                                    Button(modifier =
                                        Modifier.size(width = 200.dp, height = 50.dp),
                                        colors = ButtonColors(
                                            containerColor = Color(0xFFFF4940),
                                            contentColor = Color.White,
                                            disabledContainerColor = Color.Green,
                                            disabledContentColor = Color.Black
                                        ),
                                        onClick = {
                                            viewModel.deleteNote(note=note) {
                                                navController.navigate(NavRoute.MainScreen.route)
                                            }
                                        }
                                    )
                                    {
                                        Text(text="Delete")
                                    }
                                    Button(modifier =
                                        Modifier.size(width = 200.dp, height = 50.dp),
                                        colors = ButtonColors(
                                            containerColor = Color(0xFFFF4940),
                                            contentColor = Color.White,
                                            disabledContainerColor = Color.Green,
                                            disabledContentColor = Color.Black
                                        ),
                                        onClick = {
                                            viewModel.saveNote(note = Note(note.id, title1, subtitle1)) {
                                                navController.navigate(NavRoute.MainScreen.route)
                                            }
                                        }
                                    )
                                    {
                                        Text(text="Save")
                                    }

                                }
                            }

                        }
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
