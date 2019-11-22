package com.arctouch.codechallenge.util.extensions

import androidx.appcompat.widget.AppCompatEditText
import com.arctouch.codechallenge.util.simpleClasses.SimpleTextWatcher

fun AppCompatEditText.observeChanges(action: (String) -> Unit) {
    this.addTextChangedListener(object : SimpleTextWatcher() {
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            action(p0.toString())
        }
    })
}