package com.example.mynotesapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.runtime.ComposableTargetMarker
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.mynotesapp.NavController
import com.example.mynotesapp.NavRoute

@Composable
fun CreatingScreen(navController: NavHostController){
    var title by remember {mutableStateOf("")}
    var subtitle by remember {mutableStateOf("")}
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
                    onValueChange = {title = it},
                    label = {Text("Name")}
                )
                OutlinedTextField(
                    value = title,
                    onValueChange = {title = it},
                    label = {Text("Description")}
                )
                Button( modifier= Modifier.fillMaxWidth(),onClick = {navController.navigate(NavRoute.MainScreen.route)}) {
                    Text(text="Create new note")
                }
                Button(onClick = {}){

                }
            }
        }
    }
}