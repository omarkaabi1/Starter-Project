package com.worldline.insa.template.features.movies.data.repository

import RemoteMovieDataSource
import android.util.Log
import com.worldline.insa.template.features.movies.data.model.MovieResponse

class MovieRepository (private val remoteMovieDataSource: RemoteMovieDataSource){
    suspend fun getPopularMovies(apiKey: String): MovieResponse {
        return remoteMovieDataSource.getPopularMovies(apiKey)

    }
}


