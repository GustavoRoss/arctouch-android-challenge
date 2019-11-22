package com.arctouch.codechallenge.core.di

import com.ross.domain.boundaries.iteractors.IGetMoviesWithGenresUseCase
import com.ross.domain.useCases.GetMoviesWithGenresWithGenresUseCase
import org.koin.dsl.module

val useCaseModules = module {
    single<IGetMoviesWithGenresUseCase> { GetMoviesWithGenresWithGenresUseCase(get()) }
}