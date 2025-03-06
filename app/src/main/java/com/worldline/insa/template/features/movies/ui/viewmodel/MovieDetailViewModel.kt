package com.worldline.insa.template.features.movies.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worldline.insa.template.features.movies.data.model.Movie
import com.worldline.insa.template.features.movies.domain.usecase.GetMovieDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    movieTitle: String
) : ViewModel() {

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie: StateFlow<Movie?> = _movie

    init {
        fetchMovieDetail(movieTitle)
    }

    private fun fetchMovieDetail(title: String) {
        viewModelScope.launch {
            _movie.value = getMovieDetailUseCase.execute(title)
        }
    }
}
