package com.arctouch.codechallenge.util

import android.content.Context
import android.content.Intent
import android.os.Bundle

const val DEFAULT_BUNDLE_EXTRA = "DEFAULT_BUNDLE_EXTRA"

inline fun <reified T> Context.startActivity(extras: Bundle.() -> Unit) {
    this.startActivity(Intent(this, T::class.java).apply {
        putExtra(DEFAULT_BUNDLE_EXTRA, Bundle().apply(extras))
    })
}