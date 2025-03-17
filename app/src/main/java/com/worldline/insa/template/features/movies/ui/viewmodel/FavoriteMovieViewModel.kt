package com.worldline.insa.template.features.movies.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.worldline.insa.template.features.movies.data.local.entity.FavoriteMovie
import com.worldline.insa.template.features.movies.data.repository.FavoriteMovieRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(private val repository: FavoriteMovieRepository) : ViewModel() {

    val favoriteMovies: StateFlow<List<FavoriteMovie>> = repository.getFavorites()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun toggleFavorite(movie: FavoriteMovie) {
        viewModelScope.launch {
            val isFav = repository.isFavorite(movie.id).stateIn(viewModelScope).value
            if (isFav) {
                repository.removeFavorite(movie)
            } else {
                repository.addFavorite(movie)
            }
        }
    }
}

