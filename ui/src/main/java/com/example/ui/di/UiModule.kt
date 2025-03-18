package com.example.ui.di

import com.example.ui.viewmodel.FavoriteMovieViewModel
import com.example.ui.viewmodel.MovieDetailViewModel
import com.example.ui.viewmodel.MovieListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val uiModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { FavoriteMovieViewModel(get(),get(),get(),get()) }
}
