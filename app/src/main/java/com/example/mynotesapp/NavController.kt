package com.example.mynotesapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynotesapp.screens.CreatingScreen
import com.example.mynotesapp.screens.MainScreen
import com.example.mynotesapp.screens.NoteScreen

sealed class NavRoute(val route: String){
    object MainScreen: NavRoute("main_screen")
    object CreatingScreen: NavRoute("creating_screen")
    object NoteScreen: NavRoute("notes_screen")
}

@Composable
fun NavController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.MainScreen.route) {
        composable(NavRoute.MainScreen.route) { MainScreen(navController = navController) }
        composable(NavRoute.CreatingScreen.route) { CreatingScreen(navController = navController) }
        composable(NavRoute.NoteScreen.route) { NoteScreen(navController = navController) }
    }
}