package com.arctouch.codechallenge.ui.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.arctouch.codechallenge.core.base.BaseViewModel
import com.arctouch.codechallenge.util.extensions.defaultSchedulers
import com.arctouch.codechallenge.util.extensions.disposedBy
import com.arctouch.codechallenge.util.extensions.normalize
import com.ross.domain.boundaries.iteractors.IGetMoviesWithGenresUseCase
import com.ross.domain.models.Movie
import io.reactivex.rxkotlin.subscribeBy

class HomeViewModel(private val getMoviesWithGenresUseCase: IGetMoviesWithGenresUseCase) : BaseViewModel() {

    val movies: LiveData<List<Movie>> get() = _movies
    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    private var currentPageCount = 1L
    private var totalPages: Int? = null
    private var mergedItems: MutableList<Movie> = mutableListOf()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMoviesWithGenres(currentPageCount)
    }

    fun loadMoreMovies() {
        currentPageCount++

        val hasPagesToLoad = currentPageCount <= totalPages ?: 0

        if (hasPagesToLoad) {
            getMoviesWithGenres(currentPageCount)
        }
    }

    fun onQueryChanges(query: String) {
        mergedItems.filter {
            val currentMovieTitleNormalized = it.title.normalize()
            val normalizedQuery = query.normalize()

            currentMovieTitleNormalized.contains(normalizedQuery)
        }.also { filteredMovies ->
            _movies.postValue(filteredMovies)
        }
    }

    private fun getMoviesWithGenres(page: Long) {
        getMoviesWithGenresUseCase.getMoviesWithGenres(page)
                .defaultSchedulers()
                .subscribeBy(::onError) { upcomingMovie ->
                    if (totalPages == null) {
                        totalPages = upcomingMovie.totalPages
                    }

                    mergedItems.addAll(upcomingMovie.movies)
                    _movies.postValue(mergedItems)
                }.disposedBy(compositeDisposable)
    }
}