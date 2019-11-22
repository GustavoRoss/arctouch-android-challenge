package com.arctouch.codechallenge.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ross.domain.models.Movie

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {

    inner class DiffCallback(private val oldList: List<Movie>, private val newList: List<Movie>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                oldList[oldItemPosition] == newList[newItemPosition]

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

    }

    var movies: MutableList<Movie> = mutableListOf()
        set(newList) {
            val result = DiffUtil.calculateDiff(DiffCallback(field, newList))

            field = newList
            result.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder.inflate(parent)
    override fun getItemCount() = movies.size
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) = holder(movies[position])
}
