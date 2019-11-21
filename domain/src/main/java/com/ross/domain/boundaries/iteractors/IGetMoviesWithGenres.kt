package com.ross.domain.boundaries.iteractors

import com.ross.domain.models.UpcomingMovies
import io.reactivex.Observable

interface IGetMoviesWithGenres {
    fun getMoviesWithGenres(page: Long): Observable<UpcomingMovies>
}