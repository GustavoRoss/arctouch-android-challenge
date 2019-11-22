package com.arctouch.codechallenge.ui.movieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.arctouch.codechallenge.core.base.BaseViewModel
import com.ross.domain.models.Movie

class MovieDetailViewModel(private val movie: Movie) : BaseViewModel() {
    val movieDetail: LiveData<Movie> = liveData {
        emit(movie)
    }
}