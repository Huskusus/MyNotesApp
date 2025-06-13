package com.example.mynotesapp.screens

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mynotesapp.MainViewModel
import com.example.mynotesapp.MainViewModelFactory
import com.example.mynotesapp.NavRoute
import com.example.mynotesapp.constants.TYPE_FIREBASE
import com.example.mynotesapp.constants.TYPE_ROOM

@Composable
fun StartScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.size(width = 500.dp, height = 300.dp))
            Button(onClick = {
                mViewModel.initDatabase(TYPE_ROOM){
                navController.navigate(route = NavRoute.MainScreen.route)
                }
                             },
                colors = ButtonColors(
                    containerColor = Color(0xFFFF4940),
                    contentColor = Color.White,
                    disabledContainerColor = Color.Green,
                    disabledContentColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),
                )
                {
                Text(text= "Offline enter")
            }
            Button(onClick = {
                mViewModel.initDatabase(TYPE_FIREBASE){
                navController.navigate(NavRoute.MainScreen.route)
                }
                             },
                colors = ButtonColors(
                    containerColor = Color(0xFFFF4940),
                    contentColor = Color.White,
                    disabledContainerColor = Color.Green,
                    disabledContentColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            )
            {
                Text(text= "Authorization")
            }
        }
    }
}

