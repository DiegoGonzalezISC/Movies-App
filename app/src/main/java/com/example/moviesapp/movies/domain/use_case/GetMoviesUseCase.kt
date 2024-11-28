package com.example.moviesapp.movies.domain.use_case

import com.example.moviesapp.movies.data.remote.response.MovieDTO
import com.example.moviesapp.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {
    suspend operator fun invoke(): List<MovieDTO> {
        return try {
            repository.getMovies()
        } catch (e: Exception) {
            emptyList()
        }
    }
}