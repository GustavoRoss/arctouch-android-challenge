package com.arctouch.codechallenge.ui.home

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.util.extensions.MovieImageUrlBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ross.domain.models.Genre

@BindingAdapter("formatGenresText")
fun formatGenresText(view: AppCompatTextView, genres: List<Genre>?) {
    view.text = genres?.joinToString(separator = ", ") { it.name }
}

@BindingAdapter("loadImageAsync")
fun loadImageAsync(view: AppCompatImageView, imageURL: String?) {
    val movieImageUrlBuilder = MovieImageUrlBuilder.shared()

    Glide.with(view.context)
            .load(imageURL?.let { movieImageUrlBuilder.buildPosterUrl(it) })
            .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
            .into(view)
}