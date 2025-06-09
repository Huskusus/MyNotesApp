package com.example.mynotesapp.screens

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mynotesapp.NavRoute

@Composable
fun StartScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.size(width = 500.dp, height = 300.dp))
            Button(onClick = {navController.navigate(NavRoute.MainScreen.route)},
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
            Button(onClick = {},
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

