package com.worldline.insa.template.main

import RemoteMovieDataSource
import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.domain.usecase.GetMovieDetailUseCase
import com.worldline.insa.template.features.movies.domain.usecase.GetPopularMoviesUseCase
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailViewModel
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module



val appModule = module{
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    single { GetPopularMoviesUseCase(get()) }
    single { GetMovieDetailUseCase(get()) }
    single { MovieRepository(get()) }
    single { RemoteMovieDataSource() }
}