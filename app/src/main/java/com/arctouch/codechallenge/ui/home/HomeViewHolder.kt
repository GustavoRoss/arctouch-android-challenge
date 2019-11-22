package com.arctouch.codechallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arctouch.codechallenge.BR
import com.arctouch.codechallenge.databinding.MovieItemBinding
import com.ross.domain.models.Movie

class HomeViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun inflate(parent: ViewGroup) = HomeViewHolder(
                MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    operator fun invoke(movie: Movie, itemClickCallback: (Movie) -> Unit) {
        binding.setVariable(BR.movie, movie)
        binding.root.setOnClickListener { itemClickCallback(movie) }
    }
}