package com.arctouch.codechallenge.ui.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.arctouch.codechallenge.core.base.BaseViewModel
import com.arctouch.codechallenge.util.defaultSchedulers
import com.arctouch.codechallenge.util.disposedBy
import com.ross.domain.boundaries.iteractors.IGetMoviesWithGenres
import com.ross.domain.models.Movie
import io.reactivex.rxkotlin.subscribeBy

class HomeViewModel(private val IGetMoviesWithGenres: IGetMoviesWithGenres) : BaseViewModel() {

    val movies: LiveData<List<Movie>> get() = _movies
    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        IGetMoviesWithGenres.getMoviesWithGenres(1)
                .defaultSchedulers()
                .subscribeBy(::onError) {
                    _movies.postValue(it.movies)
                }.disposedBy(compositeDisposable)
    }
}