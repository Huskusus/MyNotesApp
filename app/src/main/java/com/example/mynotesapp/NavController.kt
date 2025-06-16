package com.example.mynotesapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynotesapp.constants.Constants.Keys.ID
import com.example.mynotesapp.constants.Constants.Screens.CREATE_SCREEN
import com.example.mynotesapp.constants.Constants.Screens.MAIN_SCREEN
import com.example.mynotesapp.constants.Constants.Screens.NOTE_SCREEN
import com.example.mynotesapp.constants.Constants.Screens.START_SCREEN
import com.example.mynotesapp.screens.CreatingScreen
import com.example.mynotesapp.screens.MainScreen
import com.example.mynotesapp.screens.NoteScreen
import com.example.mynotesapp.screens.StartScreen

sealed class NavRoute(val route: String){
    object MainScreen: NavRoute(MAIN_SCREEN)
    object CreatingScreen: NavRoute(CREATE_SCREEN)
    object NoteScreen: NavRoute(NOTE_SCREEN)
    object StartScreen: NavRoute(START_SCREEN)
}

@Composable
fun NavController(mViewModel: MainViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.MainScreen.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.CreatingScreen.route) { CreatingScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.StartScreen.route) { StartScreen(navController = navController, viewModel = mViewModel)}
        composable(NavRoute.NoteScreen.route + "/{${ID}}") {backStackEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteId = backStackEntry.arguments?.getString(ID)) }

    }
}