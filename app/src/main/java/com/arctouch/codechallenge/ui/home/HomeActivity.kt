package com.arctouch.codechallenge.ui.home

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.core.base.BaseActivity
import com.arctouch.codechallenge.core.base.BaseViewModel
import com.arctouch.codechallenge.databinding.HomeActivityBinding
import com.arctouch.codechallenge.util.observe
import com.arctouch.codechallenge.util.onLastItemReachedInLinearLayoutManager
import com.ross.domain.models.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel?
        get() = _viewModel

    private lateinit var binding: HomeActivityBinding
    private val _viewModel by viewModel<HomeViewModel>()
    private val adapter by lazy { HomeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity)
        setupRecyclerView()
        lifecycle.addObserver(_viewModel)
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.onLastItemReachedInLinearLayoutManager {
            _viewModel.loadMoreMovies()
        }
    }

    override fun subscribeUI() {
        super.subscribeUI()
        _viewModel.movies.observe(this, ::onMovies)
    }

    private fun onMovies(movies: List<Movie>) {
        adapter.movies = movies.toMutableList()
        binding.progressBar.visibility = View.INVISIBLE
    }
}
