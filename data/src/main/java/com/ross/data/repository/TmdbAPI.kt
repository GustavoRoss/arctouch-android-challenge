package com.ross.data.repository

import com.ross.data.BuildConfig
import com.ross.data.model.GenresResponse
import com.ross.data.model.MovieResponse
import com.ross.data.model.UpcomingMoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbAPI {

    companion object {
        const val DEFAULT_LANGUAGE = "pt-BR"
        const val DEFAULT_REGION = "BR"
    }

    @GET("genre/movie/list")
    fun genres(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("language") language: String = DEFAULT_LANGUAGE
    ): Observable<GenresResponse>

    @GET("movie/upcoming")
    fun upcomingMovies(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("language") language: String = DEFAULT_LANGUAGE,
            @Query("page") page: Long,
            @Query("region") region: String = DEFAULT_REGION
    ): Observable<UpcomingMoviesResponse>

    @GET("movie/{id}")
    fun movie(
            @Path("id") id: Long,
            @Query("api_key") apiKey: String,
            @Query("language") language: String = DEFAULT_LANGUAGE
    ): Observable<MovieResponse>
}