package com.worldline.insa.template.features.movies.data.repository

import RemoteMovieDataSource
import android.util.Log
import com.worldline.insa.template.features.movies.data.model.MovieResponse

class MovieRepository (private val remoteMovieDataSource: RemoteMovieDataSource){

    suspend fun getPopularMovies(apiKey: String): MovieResponse {
        Log.d("MovieRepository", "Fetching movies from API...")
        return remoteMovieDataSource.getPopularMovies(apiKey)

    }
}


