package com.arctouch.codechallenge.ui.model

import android.os.Parcelable
import com.ross.domain.models.Genre
import com.ross.domain.models.Movie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieParcelable(
        val id: Int,
        val title: String,
        val overview: String?,
        val genres: List<GenreParcelable>?,
        val genreIds: List<Int>?,
        val posterPath: String?,
        val backdropPath: String?,
        val releaseDate: String?
) : Parcelable {
    companion object {
        fun toParcel(movie: Movie) = MovieParcelable(
                movie.id,
                movie.title,
                movie.overview,
                movie.genres?.map { GenreParcelable(it.id, it.name) },
                movie.genreIds,
                movie.posterPath,
                movie.backdropPath,
                movie.releaseDate
        )
    }

    fun toEntity() = Movie(
            this.id,
            this.title,
            this.overview,
            this.genres?.map { Genre(it.id, it.name) },
            this.genreIds,
            this.posterPath,
            this.backdropPath,
            this.releaseDate
    )
}