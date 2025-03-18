package com.example.domain.di

import com.example.domain.usecase.GetFavoriteMoviesUseCase
import com.example.domain.usecase.GetMovieDetailUseCase
import com.example.domain.usecase.GetPopularMoviesUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetPopularMoviesUseCase(get()) }
    single { GetMovieDetailUseCase(get()) }
    single { GetFavoriteMoviesUseCase(get()) }
}
