package com.example.app.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.worldline.insa.template.features.movies.data.model.MovieResponse

interface MovieApi {

    @GET("movie/popular?language=en-US&page=1")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): MovieResponse
}
