package com.example.moviesapp.movies.domain.use_case

import com.example.moviesapp.movies.data.remote.response.MovieDTO
import com.example.moviesapp.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {
    suspend operator fun invoke(page: Int): List<MovieDTO> {
        return try {
            repository.getMovies(page)
        } catch (e: Exception) {
            emptyList()
        }
    }
}