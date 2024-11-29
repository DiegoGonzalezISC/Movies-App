package com.example.moviesapp.movies.domain.repository

import com.example.moviesapp.movies.data.remote.response.MovieDTO

interface MoviesRepository {
    suspend fun getNowPlayingMovies(): List<MovieDTO>
    suspend fun getMovies(page: Int): List<MovieDTO>
}