package com.arctouch.codechallenge.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arctouch.codechallenge.util.observe

abstract class BaseActivity : AppCompatActivity() {
    protected open val baseViewModel: BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeUI()
    }

    protected open fun subscribeUI() {
        baseViewModel?.error?.observe(this, ::onError)
    }

    protected open fun onError(throwable: Throwable) {
        // Do something with error
    }
}
