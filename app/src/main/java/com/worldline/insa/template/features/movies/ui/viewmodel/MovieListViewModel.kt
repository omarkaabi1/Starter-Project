package com.worldline.insa.template.features.movies.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worldline.insa.template.features.movies.data.model.Movie
import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.launch

class MovieListViewModel(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>(emptyList())
    val movies: LiveData<List<Movie>> = _movies

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                val response = getPopularMoviesUseCase.execute("6beb73626089fde8c77c1cc6bcce699e")
                _movies.value = response
            } catch (exception: Exception) {
                _movies.value = emptyList()
            }
        }
    }

}
