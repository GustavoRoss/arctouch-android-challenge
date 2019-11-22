package com.arctouch.codechallenge.core.di

import com.ross.data.services.MovieServices
import com.ross.domain.boundaries.repository.MovieRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val repositoryModules = module {
    single<MovieRepository> { MovieServices(createRepository(get())) }
}

val retrofitModule = module {
    single {
        Retrofit.Builder()
                .baseUrl(com.ross.data.BuildConfig.BASE_URL)
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}

private inline fun <reified T> createRepository(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}