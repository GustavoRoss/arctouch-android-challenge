package com.arctouch.codechallenge.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.onLastItemReachedInLinearLayoutManager(action: () -> Unit) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val layoutManager = this@onLastItemReachedInLinearLayoutManager.layoutManager as? LinearLayoutManager

            layoutManager?.apply {
                val lastVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()

                if (lastVisibleItemPosition == (itemCount - 1)) {
                    action()
                }
            }
        }
    })
}