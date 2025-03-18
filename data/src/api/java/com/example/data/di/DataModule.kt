package com.example.data.di

import com.example.data.repository.LocalFavoriteMovieRepository
import com.example.data.repository.RemoteMovieRepository
import com.example.data.retrofit.RemoteMovieDataSource
import com.example.domain.interfaces.FavoriteMovieRepository
import com.example.domain.interfaces.MovieRepository
import org.koin.dsl.module

val dataModuleNetwork = module {
    single<MovieRepository> { RemoteMovieRepository(get()) }
    single { RemoteMovieDataSource() }
    single<FavoriteMovieRepository> { LocalFavoriteMovieRepository(get()) }
}