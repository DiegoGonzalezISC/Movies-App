package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.movies.presentation.MoviesScreen
import com.example.moviesapp.movies.presentation.MoviesViewModel
import com.example.moviesapp.ui.commons.MoviesBottomBar
import com.example.moviesapp.ui.commons.MoviesTopAppBar
import com.example.moviesapp.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesAppTheme {
                val nowPlayingMoviesState by moviesViewModel.moviesState.collectAsState()
                Scaffold(
                    topBar = {
                        MoviesTopAppBar()
                    },
                    bottomBar = { MoviesBottomBar() },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MoviesScreen(nowPlayingMoviesState, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviesAppTheme {
        Greeting("Android")
    }
}