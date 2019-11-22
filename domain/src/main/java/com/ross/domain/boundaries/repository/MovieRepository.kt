package com.ross.domain.boundaries.repository

import com.ross.domain.models.Genre
import com.ross.domain.models.UpcomingMovies
import io.reactivex.Observable

interface MovieRepository {
    fun getUpcomingMovies(page: Long): Observable<UpcomingMovies>
    fun getGenres(): Observable<List<Genre>>
}