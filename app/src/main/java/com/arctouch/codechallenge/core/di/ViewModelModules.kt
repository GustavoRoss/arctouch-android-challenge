package com.arctouch.codechallenge.core.di

import com.arctouch.codechallenge.ui.home.HomeViewModel
import com.arctouch.codechallenge.ui.movieDetail.MovieDetailViewModel
import com.ross.domain.models.Movie
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { HomeViewModel(get()) }
    viewModel { (movie: Movie) -> MovieDetailViewModel(movie) }
}