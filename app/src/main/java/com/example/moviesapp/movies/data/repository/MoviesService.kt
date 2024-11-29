package com.example.moviesapp.movies.data.repository

import com.example.moviesapp.movies.data.remote.response.MoviesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): MoviesResponseDTO

    @GET("discover/movie")
    suspend fun getMovies(@Query("page") page: Int = 1): MoviesResponseDTO
}