package com.ross.data.services

import com.ross.data.model.UpcomingMoviesResponse
import com.ross.data.repository.TmdbRepository
import com.ross.domain.models.Genre
import com.ross.domain.models.UpcomingMovies
import com.ross.domain.repository.MovieRepository
import io.reactivex.Observable

class MovieServices(private val tmdbRepository: TmdbRepository) : MovieRepository {
    override fun getGenres(): Observable<List<Genre>> {
        return tmdbRepository.genres()
                .map { it.genres }
    }

    override fun getUpcomingMovies(page: Long): Observable<UpcomingMovies> {
        return tmdbRepository.upcomingMovies(page = page)
                .map { response ->
                    UpcomingMoviesResponse
                            .UpcommingMoviesMapper
                            .map(response)
                }
    }
}