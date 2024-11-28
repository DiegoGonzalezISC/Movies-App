package com.example.moviesapp.movies.data.repository

import com.example.moviesapp.movies.data.remote.response.MoviesResponseDTO
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): MoviesResponseDTO

    @GET("discover/movie")
    suspend fun getMovies(): MoviesResponseDTO
}