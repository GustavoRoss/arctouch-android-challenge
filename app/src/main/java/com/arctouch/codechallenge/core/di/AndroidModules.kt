package com.arctouch.codechallenge.core.di

import com.ross.domain.boundaries.storage.Cache
import com.ross.data.cache.AndroidCache
import org.koin.dsl.module

val androidModule = module {
    single<Cache> { AndroidCache() }
}