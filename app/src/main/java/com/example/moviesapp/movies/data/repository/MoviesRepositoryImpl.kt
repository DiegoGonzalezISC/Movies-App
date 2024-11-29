package com.example.moviesapp.movies.data.repository

import com.example.moviesapp.movies.data.remote.response.MovieDTO
import com.example.moviesapp.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl@Inject constructor(private val api: MoviesService): MoviesRepository {
    override suspend fun getNowPlayingMovies(): List<MovieDTO> {
        val response = api.getNowPlayingMovies()
        return response.movieDTOS
    }

    override suspend fun getMovies(page: Int): List<MovieDTO> {
        val response = api.getMovies(page)
        return response.movieDTOS
    }
}