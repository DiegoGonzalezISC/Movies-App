package com.example.moviesapp.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.movies.data.remote.response.MovieDTO
import com.example.moviesapp.movies.domain.use_case.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
): ViewModel() {
    private val _moviesState = MutableStateFlow(MoviesState())
    val moviesState = _moviesState.asStateFlow()

    init {
        getMovies()
    }

    fun getNowPlayingMovies() {
        _moviesState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = getNowPlayingMoviesUseCase()
            _moviesState.update { it.copy(isLoading = false, movieDTOS = result) }
        }
    }

    fun getMovies() {
        _moviesState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = getNowPlayingMoviesUseCase()
            _moviesState.update { it.copy(isLoading = false, movieDTOS = result) }
        }
    }
}

data class MoviesState (
    val isLoading: Boolean = false,
    val movieDTOS: List<MovieDTO> = emptyList(),
    val error: String = ""
)
