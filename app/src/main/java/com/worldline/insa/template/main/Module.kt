package com.worldline.insa.template.main

import androidx.room.Room
import com.worldline.insa.template.features.movies.data.local.AppDatabase
import com.worldline.insa.template.features.movies.data.repository.FavoriteMovieRepository
import com.worldline.insa.template.features.movies.data.retrofit.RemoteMovieDataSource
import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.domain.usecase.GetMovieDetailUseCase
import com.worldline.insa.template.features.movies.domain.usecase.GetPopularMoviesUseCase
import com.worldline.insa.template.features.movies.ui.viewmodel.FavoriteMovieViewModel
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailViewModel
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module



val appModule = module{
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { FavoriteMovieViewModel(get()) }
    single { GetPopularMoviesUseCase(get()) }
    single { GetMovieDetailUseCase(get()) }
    single { MovieRepository(get()) }
    single { RemoteMovieDataSource() }
    single { FavoriteMovieRepository(get()) }
    single { get<AppDatabase>().favoriteMovieDao() }
    single {Room.databaseBuilder(androidContext(), AppDatabase::class.java, "FavoriteMovies_db")
            .fallbackToDestructiveMigration()
            .build()}
}
