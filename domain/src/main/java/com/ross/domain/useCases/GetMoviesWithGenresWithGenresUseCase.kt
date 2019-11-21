package com.ross.domain.useCases

import com.ross.domain.boundaries.iteractors.IGetMoviesWithGenres
import com.ross.domain.models.UpcomingMovies
import com.ross.domain.repository.MovieRepository
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

class GetMoviesWithGenresWithGenresUseCase(private val movieRepository: MovieRepository) : IGetMoviesWithGenres {
    override fun getMoviesWithGenres(page: Long): Observable<UpcomingMovies> {
        return Observable.zip(
                movieRepository.getGenres(),
                movieRepository.getUpcomingMovies(page), BiFunction { genres, upcomingMovies ->
            val movies = upcomingMovies.movies.map { movie ->

                val genresAvailable = movie.genreIds?.let { genreIds ->
                    genres.filter { genre -> genre.id in genreIds }
                }

                movie.copy(genres = genresAvailable)
            }
            upcomingMovies.copy(movies = movies)
        })
    }
}