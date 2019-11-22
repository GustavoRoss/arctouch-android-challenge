package com.arctouch.codechallenge.util

import com.ross.data.BuildConfig

private const val POSTER_URL = "https://image.tmdb.org/t/p/w154"
private const val BACKDROP_URL = "https://image.tmdb.org/t/p/w780"

class MovieImageUrlBuilder {

    companion object {
        private var INSTANCE: MovieImageUrlBuilder? = null
        fun shared(): MovieImageUrlBuilder {
            if (INSTANCE == null) {
                INSTANCE = MovieImageUrlBuilder()
            }
            return INSTANCE!!
        }
    }

    fun buildPosterUrl(posterPath: String): String {
        return POSTER_URL + posterPath + "?api_key=" + BuildConfig.API_KEY
    }

    fun buildBackdropUrl(backdropPath: String): String {
        return BACKDROP_URL + backdropPath + "?api_key=" + BuildConfig.API_KEY
    }
}
