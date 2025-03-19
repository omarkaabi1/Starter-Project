package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Movie
import com.example.domain.usecase.AddFavoriteMovieUseCase
import com.example.domain.usecase.GetFavoriteMoviesUseCase
import com.example.domain.usecase.IsFavoriteMovieUseCase
import com.example.domain.usecase.RemoveFavoriteMovieUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(
    getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
    private val addFavoriteMovieUseCase: AddFavoriteMovieUseCase,
    private val removeFavoriteMovieUseCase: RemoveFavoriteMovieUseCase,
    private val isFavoriteMovieUseCase: IsFavoriteMovieUseCase
) : ViewModel() {

    val favoriteMovies: StateFlow<List<Movie>> = getFavoriteMoviesUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {
            val isFav = isFavoriteMovieUseCase(movie.id).stateIn(viewModelScope).value
            if (isFav) {
                removeFavoriteMovieUseCase(movie)
            } else {
                addFavoriteMovieUseCase(movie)
            }
        }
    }
}
