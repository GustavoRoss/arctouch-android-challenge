package com.ross.domain.models

data class UpcomingMovies(
        val page: Int,
        val totalPages: Int,
        val totalResults: Int,
        val movies: List<Movie>
)