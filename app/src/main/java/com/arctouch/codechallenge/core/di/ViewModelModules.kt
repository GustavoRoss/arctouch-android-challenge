package com.arctouch.codechallenge.core.di

import com.arctouch.codechallenge.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { HomeViewModel(get()) }
}