package com.arctouch.codechallenge.util.extensions

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun Disposable.disposedBy(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}


fun <T> Observable<T>.defaultSchedulers(): Observable<T> {
    return this
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}