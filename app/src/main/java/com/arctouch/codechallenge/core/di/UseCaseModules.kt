package com.arctouch.codechallenge.core.di

import com.ross.domain.boundaries.iteractors.IGetMoviesWithGenresUseCase
import com.ross.domain.useCases.GetMoviesWithGenresWithGenresUseCaseUseCase
import org.koin.dsl.module

val useCaseModules = module {
    single<IGetMoviesWithGenresUseCase> { GetMoviesWithGenresWithGenresUseCaseUseCase(get()) }
}