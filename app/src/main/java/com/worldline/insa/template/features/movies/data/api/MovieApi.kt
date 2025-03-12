package com.example.app.api

import com.worldline.insa.template.features.movies.data.api.MovieResponse
import com.worldline.insa.template.features.movies.data.api.MovieResponseItem
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieApi {

    @GET("movie/popular?language=en-US&page=1")
    suspend fun getPopularMovies(): MovieResponse

    @GET("movie/{movie_id}?language=en-US")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): MovieResponseItem

}
