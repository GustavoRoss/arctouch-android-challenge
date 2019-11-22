package com.ross.data.services

import com.ross.data.model.UpcomingMoviesResponse
import com.ross.data.repository.TmdbAPI
import com.ross.domain.models.Genre
import com.ross.domain.models.UpcomingMovies
import com.ross.domain.boundaries.repository.MovieRepository
import io.reactivex.Observable

class MovieServices(private val tmdbAPI: TmdbAPI) : MovieRepository {
    override fun getGenres(): Observable<List<Genre>> {
        return tmdbAPI.genres()
                .map { it.genres }
    }

    override fun getUpcomingMovies(page: Long): Observable<UpcomingMovies> {
        return tmdbAPI.upcomingMovies(page = page)
                .map { response ->
                    UpcomingMoviesResponse
                            .UpcommingMoviesMapper
                            .map(response)
                }
    }
}