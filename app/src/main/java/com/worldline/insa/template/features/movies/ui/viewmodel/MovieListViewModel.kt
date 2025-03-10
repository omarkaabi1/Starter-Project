package com.worldline.insa.template.features.movies.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worldline.insa.template.features.movies.data.model.Movie
import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieListViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>(emptyList())
    val movies: LiveData<List<Movie>> = _movies

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                val response = movieRepository.getPopularMovies("6beb73626089fde8c77c1cc6bcce699e")
                _movies.value = response.results
                Log.d("api", "Movies fetched successfully")
                Log.d("API Response", response.toString())
            } catch (exception: Exception) {
                _movies.value = emptyList()
                Log.e("api", "Error fetching movies: ${exception.message}", exception)
            }
        }
    }

}
