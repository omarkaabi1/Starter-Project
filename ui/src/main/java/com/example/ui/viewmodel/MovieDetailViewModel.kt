package com.example.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Movie
import com.example.domain.usecase.GetMovieDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val getMovieDetailUseCase: GetMovieDetailUseCase) : ViewModel() {

    private val _movieDetail = MutableStateFlow<Movie?>(null)
    val movieDetail: StateFlow<Movie?> = _movieDetail

    fun fetchMovieDetails(movieId: Int) {
        viewModelScope.launch {
            try {
                val movie = getMovieDetailUseCase(movieId)
                _movieDetail.value = movie
            } catch (e: Exception) {
                _movieDetail.value = null
                Log.e("MovieDetailViewModel", "Error fetching details: ", e)
            }
        }
    }
}
