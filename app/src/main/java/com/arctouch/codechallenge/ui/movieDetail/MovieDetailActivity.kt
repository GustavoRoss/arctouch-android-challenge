package com.arctouch.codechallenge.ui.movieDetail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arctouch.codechallenge.BR
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.core.base.BaseActivity
import com.arctouch.codechallenge.core.base.BaseViewModel
import com.arctouch.codechallenge.databinding.ActivityMovieDetailBinding
import com.arctouch.codechallenge.ui.model.MovieParcelable
import com.arctouch.codechallenge.util.extensions.DEFAULT_BUNDLE_EXTRA
import com.arctouch.codechallenge.util.extensions.observe
import com.ross.domain.models.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override val baseViewModel: BaseViewModel?
        get() = _viewModel

    private val movieParcelable by lazy {
        intent.extras?.getBundle(DEFAULT_BUNDLE_EXTRA)
                ?.getParcelable<MovieParcelable>(MOVIE_EXTRA)
    }

    private val _viewModel by viewModel<MovieDetailViewModel>(parameters = {
        parametersOf(movieParcelable?.toEntity())
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
    }

    override fun subscribeUI() {
        super.subscribeUI()
        _viewModel.movieDetail.observe(this, ::onMovie)
    }

    private fun onMovie(movie: Movie) {
        binding.setVariable(BR.movie, movie)
    }

    companion object {
        const val MOVIE_EXTRA = "MOVIE_EXTRA"
    }
}
