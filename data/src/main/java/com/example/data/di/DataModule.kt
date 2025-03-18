package com.example.data.di

import androidx.room.Room
import com.example.data.local.AppDatabase
import com.example.data.repository.FavoriteMovieRepository
import com.example.data.repository.MovieRepository
import com.example.data.retrofit.RemoteMovieDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dataModule = module {
    single { MovieRepository(get()) }
    single { RemoteMovieDataSource() }
    single { FavoriteMovieRepository(get()) }
    single { get<AppDatabase>().favoriteMovieDao() }
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "FavoriteMovies_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
