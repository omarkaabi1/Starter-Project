package com.example.app.api

import com.worldline.insa.template.features.movies.data.api.MovieResponse
import retrofit2.http.GET


interface MovieApi {

    @GET("movie/popular?language=en-US&page=1")
    suspend fun getPopularMovies(): MovieResponse
}
