package com.example.data.di

import androidx.room.Room
import com.example.data.local.AppDatabase
import com.example.data.repository.LocalFavoriteMovieRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dataModuleCommon = module {
    single { LocalFavoriteMovieRepository(get()) }
    single { get<AppDatabase>().favoriteMovieDao() }
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "FavoriteMovies_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
