package com.worldline.insa.template.features.movies.ui.viewmodel
/*

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worldline.insa.template.features.movies.data.model.Movie
import com.worldline.insa.template.features.movies.domain.usecase.GetMovieDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class MovieDetailViewModel(
    private val getMovieDetail: GetMovieDetailUseCase,
    movieTitle: String
) : ViewModel() {

    private val _movie = MutableStateFlow<MovieDetailState>(MovieDetailState.Loading)
    val movie: StateFlow<MovieDetailState> = _movie

    init {
        fetchMovieDetail(movieTitle)
    }

    private fun fetchMovieDetail(title: String) {
        viewModelScope.launch {
            val result = getMovieDetail(title)
            if(result != null){
                _movie.value = MovieDetailState.Success(movie = result)
            } else{
                _movie.value = MovieDetailState.Error
            }        }
    }
}

sealed class MovieDetailState {
    data object Loading : MovieDetailState()
    data object Error : MovieDetailState()
    data class Success(val movie: Movie) : MovieDetailState()
}
*/