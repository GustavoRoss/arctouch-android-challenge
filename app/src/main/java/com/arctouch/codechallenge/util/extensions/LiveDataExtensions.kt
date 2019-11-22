package com.arctouch.codechallenge.util.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, callback: (T) -> Unit) {
    this.observe(lifecycleOwner, Observer { it?.let { callback(it) } })
}