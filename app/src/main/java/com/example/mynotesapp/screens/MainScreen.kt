package com.example.mynotesapp.screens
import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.mynotesapp.model.Note
import com.example.mynotesapp.ui.theme.MyNotesAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController){
    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(NavRoute.CreatingScreen.route) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Here I write", modifier = Modifier.size(100.dp), tint = Color.White)
            }
        }
    )
    {

    }
}


@Preview(showBackground = true)
@Composable
fun ReviewMainScr(){
    MyNotesAppTheme {
        MainScreen(navController = rememberNavController())
    }
}

@Composable
fun NoteOne(note: Note, navController: NavHostController){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp, horizontal = 20.dp)
        .clickable{navController.navigate(NavRoute.NoteScreen.route)},
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ){
        Column(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
                )
            Text(text = note.subtitle)
        }
    }
}
