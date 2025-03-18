package com.example.domain.di

import com.example.domain.usecase.AddFavoriteMovieUseCase
import com.example.domain.usecase.GetFavoriteMoviesUseCase
import com.example.domain.usecase.GetMovieDetailUseCase
import com.example.domain.usecase.GetPopularMoviesUseCase
import com.example.domain.usecase.IsFavoriteMovieUseCase
import com.example.domain.usecase.RemoveFavoriteMovieUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetPopularMoviesUseCase(get()) }
    single { GetMovieDetailUseCase(get()) }
    single { GetFavoriteMoviesUseCase(get()) }
    single { AddFavoriteMovieUseCase(get()) }
    single { IsFavoriteMovieUseCase(get()) }
    single { RemoveFavoriteMovieUseCase(get()) }

}
