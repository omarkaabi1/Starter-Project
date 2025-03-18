package com.example.data.di

import com.example.data.repository.LocalMovieRepository
import com.example.domain.interfaces.MovieRepository
import org.koin.dsl.module


val dataModuleNetwork = module {
    single<MovieRepository> { LocalMovieRepository() }
}