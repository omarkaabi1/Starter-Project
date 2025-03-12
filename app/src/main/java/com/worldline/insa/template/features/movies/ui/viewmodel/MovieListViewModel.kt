package com.worldline.insa.template.features.movies.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worldline.insa.template.features.movies.domain.model.Movie
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
                val response = getPopularMoviesUseCase.execute()
                _movies.value = response
            } catch (exception: Exception) {
                _movies.value = emptyList()
            }
        }
    }


}
