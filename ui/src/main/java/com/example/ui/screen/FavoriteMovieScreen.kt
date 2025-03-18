package com.example.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.model.toMovie
import com.example.ui.viewmodel.FavoriteMovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteMovieScreen(viewModel: FavoriteMovieViewModel, navController: NavController) {
    val favoriteMovies = viewModel.favoriteMovies.collectAsState().value

    Scaffold(
        topBar = { TopAppBar(title = { Text("Favorite Movies") }) }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            items(favoriteMovies) { favoriteMovie ->
                MovieItem(
                    movie = favoriteMovie.toMovie(),
                    isFavorite = true,
                    onFavoriteClick = { viewModel.toggleFavorite(favoriteMovie) },
                    onClick = { navController.navigate("movieDetail/${favoriteMovie.id}") }
                )
            }
        }
    }
}
