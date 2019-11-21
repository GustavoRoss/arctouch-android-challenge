package com.arctouch.codechallenge.core.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel(), LifecycleObserver {

    protected val compositeDisposable = CompositeDisposable()

    // I do not intend to emit a Throwable to the view, in more complex projects I would send a custom error to the view to work better with it
    val error: LiveData<Throwable> get() = _error
    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    protected fun onError(throwable: Throwable) {
        _error.postValue(throwable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}