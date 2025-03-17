package com.worldline.insa.template.features.movies.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.worldline.insa.template.features.movies.data.local.entity.toFavoriteMovie
import com.worldline.insa.template.features.movies.domain.model.Movie
import com.worldline.insa.template.features.movies.ui.viewmodel.FavoriteMovieViewModel
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(viewModel: MovieListViewModel, favoriteViewModel: FavoriteMovieViewModel, navController: NavController) {
    val movies by viewModel.movies.observeAsState(emptyList())
    val favorites by favoriteViewModel.favoriteMovies.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Top Movies") }) }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            items(movies) { movie ->
                val isFavorite = favorites.any { it.id == movie.id }
                MovieItem(movie, isFavorite, { favoriteViewModel.toggleFavorite(movie.toFavoriteMovie()) }) {
                    navController.navigate("movieDetail/${movie.id}")
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, isFavorite: Boolean, onFavoriteClick: () -> Unit, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = movie.posterPath),
            contentDescription = movie.title,
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = movie.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onFavoriteClick) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Toggle Favorite"
            )
        }
    }
}
