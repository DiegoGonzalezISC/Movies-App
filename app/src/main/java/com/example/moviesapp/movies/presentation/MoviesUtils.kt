package com.example.moviesapp.movies.presentation

import com.example.moviesapp.movies.data.remote.response.MovieDTO

object MoviesUtils {
    fun providesMoviesMock(): MutableList<MovieDTO> {
        val movieDTOS: MutableList<MovieDTO> = mutableListOf()
        for (i in 1..10) {
            movieDTOS.add(
                MovieDTO(
                    id = i,
                    title = "Movie $i",
                    adult = false,
                    backdropPath = "/path",
                    genreIds = listOf(1, 2),
                    originalLanguage = "en",
                    originalTitle = "Movie $i",
                    overview = "Overview",
                    popularity = 1.0,
                    posterPath = "/path",
                    releaseDate = "2021-01-01",
                    video = false,
                    voteAverage = 1.0,
                    voteCount = 1
                )
            )
        }
        return movieDTOS
    }
}