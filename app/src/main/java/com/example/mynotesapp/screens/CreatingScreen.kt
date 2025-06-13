package com.example.mynotesapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.mynotesapp.MainViewModel
import com.example.mynotesapp.NavRoute
import com.example.mynotesapp.model.Note

@Composable
fun CreatingScreen(navController: NavHostController, viewModel: MainViewModel){
    var title by remember {mutableStateOf("")}
    var subtitle by remember {mutableStateOf("")}
    var stateOfButton by remember { mutableStateOf(false) }
    Scaffold{ paddingValue ->
        Box(
            modifier = Modifier.padding(paddingValue),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Addition note")

                OutlinedTextField(
                    value = title,
                    onValueChange = {title = it
                                    stateOfButton = title.isNotEmpty() && subtitle.isNotEmpty()},
                    label = {Text("Name")},
                    isError = title.isEmpty()
                )
                OutlinedTextField(
                    value = subtitle,
                    onValueChange = {subtitle = it
                        stateOfButton = title.isNotEmpty() && subtitle.isNotEmpty()},
                    label = {Text("Description")},
                    isError = subtitle.isEmpty()
                )
                Button(
                    modifier= Modifier.fillMaxWidth(),
                    onClick = {
                    viewModel.addNote(note = Note(title=title, subtitle = subtitle)){
                        navController.navigate(NavRoute.MainScreen.route)
                    }},
                    enabled = stateOfButton
                ) {
                    Text(text="Create new note")
                }
            }
        }
    }
}

