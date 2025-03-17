package com.worldline.insa.template.features.movies.data.retrofit

import com.worldline.insa.template.features.movies.data.api.MovieApi
import com.worldline.insa.template.features.movies.data.api.MovieResponse
import com.worldline.insa.template.features.movies.data.api.MovieResponseItem
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteMovieDataSource {
    private val movieApi: MovieApi
    init {
        val apiKeyInterceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val originalUrl = originalRequest.url

            val newUrl = originalUrl.newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val newRequest = originalRequest.newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    suspend fun getPopularMovies(): MovieResponse {
        return movieApi.getPopularMovies()
    }
    suspend fun getMovieDetails(movieId: Int): MovieResponseItem {
        return movieApi.getMovieDetails(movieId)
    }

    companion object{
        const val API_KEY = "6beb73626089fde8c77c1cc6bcce699e"

    }
}