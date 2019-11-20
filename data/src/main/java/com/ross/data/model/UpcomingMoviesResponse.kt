package com.ross.data.model

import com.squareup.moshi.Json

data class UpcomingMoviesResponse(
        val page: Int,
        val results: List<Movie>,
        @Json(name = "total_pages") val totalPages: Int,
        @Json(name = "total_results") val totalResults: Int
)

data class Movie(
        val id: Int,
        val title: String,
        val overview: String?,
        val genres: List<Genre>?,
        @Json(name = "genre_ids") val genreIds: List<Int>?,
        @Json(name = "poster_path") val posterPath: String?,
        @Json(name = "backdrop_path") val backdropPath: String?,
        @Json(name = "release_date") val releaseDate: String?
)