package com.example.moviesapp.movies.domain.use_case

import com.example.moviesapp.movies.domain.repository.MoviesRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {
    suspend operator fun invoke() = repository.getNowPlayingMovies()
}