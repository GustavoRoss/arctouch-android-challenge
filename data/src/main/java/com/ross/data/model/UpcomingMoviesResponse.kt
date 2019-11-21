package com.ross.data.model

import com.ross.data.utils.Mapper
import com.ross.domain.models.Genre
import com.ross.domain.models.Movie
import com.ross.domain.models.UpcomingMovies
import com.squareup.moshi.Json

data class UpcomingMoviesResponse(
        val page: Int,
        val results: List<MovieResponse>,
        @Json(name = "total_pages") val totalPages: Int,
        @Json(name = "total_results") val totalResults: Int
){

    object UpcommingMoviesMapper : Mapper<UpcomingMoviesResponse, UpcomingMovies>() {
        override fun map(source: UpcomingMoviesResponse) = UpcomingMovies(
                source.page,
                source.totalPages, source.totalResults,
                MovieResponse.MovieMapper.mapCollection(source.results)
        )
    }
}

data class MovieResponse(
        val id: Int,
        val title: String,
        val overview: String?,
        val genres: List<Genre>?,
        @Json(name = "genre_ids") val genreIds: List<Int>?,
        @Json(name = "poster_path") val posterPath: String?,
        @Json(name = "backdrop_path") val backdropPath: String?,
        @Json(name = "release_date") val releaseDate: String?
) {
    object MovieMapper : Mapper<MovieResponse, Movie>() {
        override fun map(source: MovieResponse) = Movie(
                source.id,
                source.title,
                source.overview,
                source.genres,
                source.genreIds,
                source.posterPath,
                source.backdropPath,
                source.releaseDate
        )
    }
}