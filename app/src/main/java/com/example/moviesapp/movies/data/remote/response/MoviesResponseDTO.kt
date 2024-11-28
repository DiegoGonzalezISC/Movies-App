package com.example.moviesapp.movies.data.remote.response


import com.google.gson.annotations.SerializedName

data class MoviesResponseDTO(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movieDTOS: List<MovieDTO>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)