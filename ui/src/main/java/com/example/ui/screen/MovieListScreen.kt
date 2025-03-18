package com.example.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.domain.model.Movie
import com.example.ui.viewmodel.FavoriteMovieViewModel
import com.example.ui.viewmodel.MovieListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel,
    favoriteViewModel: FavoriteMovieViewModel,
    navController: NavController
) {
    val movies by viewModel.movies.observeAsState(emptyList())
//    val favorites by favoriteViewModel.favoriteMovies.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Top Movies") }) }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            items(movies) { movie ->
                val isFavorite = false //favorites.any { it.id == movie.id }
                MovieItem(movie, isFavorite, { /*favoriteViewModel.toggleFavorite(movie.toFavoriteMovie())*/ }) {
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
