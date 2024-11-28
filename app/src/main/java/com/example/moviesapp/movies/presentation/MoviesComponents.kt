package com.example.moviesapp.movies.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.example.moviesapp.core.Constants.IMAGE_URL_200
import com.example.moviesapp.movies.data.remote.response.MovieDTO
import com.example.moviesapp.movies.presentation.MoviesUtils.providesMoviesMock

@Composable
fun MoviesScreen(
    moviesState: MoviesState,
    modifier: Modifier
) {
    Box(modifier = modifier) {
        if (moviesState.isLoading) {
            CircularProgressIndicator()
        } else {
            // Movies list
            NowPlayingList(nowPlayingMovieDTOS = moviesState.movieDTOS)
        }
    }
}

@Composable
fun NowPlayingList(nowPlayingMovieDTOS: List<MovieDTO>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(nowPlayingMovieDTOS, key = { it.id }) { movie ->
            MovieItem(movieDTO = movie)
        }
    }
}

@Composable
fun MovieItem(movieDTO: MovieDTO) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(300.dp)
            .clip(RoundedCornerShape(16.dp)) // Rounded corners on click effect
            .clickable(
                onClick = { /* TODO */ },
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true)
            ),
    ) {
        val imageUrl = IMAGE_URL_200 + movieDTO.posterPath
        val painter = rememberAsyncImagePainter(imageUrl)
        Box(modifier = Modifier.fillMaxSize()) {
            // Movie poster
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 300f // Adjust this value to control the gradient position
                        )
                    )
            )
            Text(
                text = movieDTO.title,
                maxLines = 2,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    val movieDTOS: MutableList<MovieDTO> = providesMoviesMock()
    MoviesScreen(
        moviesState = MoviesState(movieDTOS = movieDTOS),
        modifier = Modifier
    )
}

