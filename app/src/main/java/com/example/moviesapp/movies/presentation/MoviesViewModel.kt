package com.example.moviesapp.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.movies.data.remote.response.MovieDTO
import com.example.moviesapp.movies.domain.use_case.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
    private val _moviesState = MutableStateFlow(MoviesState())
    val moviesState = _moviesState.asStateFlow()

    private val _page = MutableStateFlow(1)

    init {
        getMovies()
    }

    fun getMovies() {
        _moviesState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = getMoviesUseCase(_page.value)
            _moviesState.update {
                val updatedMovieList = it.movieDTOS.toMutableList().apply {
                    addAll(result)
                }
                it.copy(
                    isLoading = false,
                    movieDTOS = updatedMovieList
                )
            }
            _page.update { it + 1 }
        }
    }
}

data class MoviesState(
    val isLoading: Boolean = false,
    val movieDTOS: List<MovieDTO> = emptyList(),
    val error: String = ""
)
