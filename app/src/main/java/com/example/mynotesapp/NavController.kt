package com.example.mynotesapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynotesapp.screens.CreatingScreen
import com.example.mynotesapp.screens.MainScreen
import com.example.mynotesapp.screens.NoteScreen
import com.example.mynotesapp.screens.StartScreen

sealed class NavRoute(val route: String){
    object MainScreen: NavRoute("main_screen")
    object CreatingScreen: NavRoute("creating_screen")
    object NoteScreen: NavRoute("notes_screen")
    object StartScreen: NavRoute("notes_start")
}

@Composable
fun NavController(mViewModel: MainViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.MainScreen.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.CreatingScreen.route) { CreatingScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.NoteScreen.route) { NoteScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.StartScreen.route) { StartScreen(navController = navController, viewModel = mViewModel) }
    }
}