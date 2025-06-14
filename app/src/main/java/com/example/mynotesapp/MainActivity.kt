package com.example.mynotesapp

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynotesapp.ui.theme.MyNotesAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesAppTheme {
                val context = LocalContext.current
                val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {TopAppBar(
                        title = {Text(text="Мои заметки")},
                        colors = TopAppBarColors(
                            containerColor = Color.Blue,
                            scrolledContainerColor = MaterialTheme.colorScheme.onPrimary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                    },
                    content = { paddingValue->
                        Box(modifier = Modifier.padding(paddingValue),
                            contentAlignment = Alignment.Center)
                        {
                            NavController(mViewModel)

                        }
                    }
                )

            }
    }
}}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Starter(mViewModel: MainViewModel) {
    MyNotesAppTheme {
    }
}
