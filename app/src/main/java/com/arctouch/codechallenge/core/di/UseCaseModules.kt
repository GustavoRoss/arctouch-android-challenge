package com.arctouch.codechallenge.core.di

import com.ross.domain.boundaries.iteractors.IGetMoviesWithGenres
import com.ross.domain.useCases.GetMoviesWithGenresWithGenresUseCase
import org.koin.dsl.module

val useCaseModules = module {
    single<IGetMoviesWithGenres> { GetMoviesWithGenresWithGenresUseCase(get()) }
}