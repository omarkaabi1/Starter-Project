package com.worldline.insa.template.features.movies.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.worldline.insa.template.features.movies.data.model.Movie
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailState
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(viewModel: MovieListViewModel, navController: NavController) {
    val movies by viewModel.movies.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Movies") }) }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            items(movies) { movie ->
                MovieItem(movie) { navController.navigate("movieDetail/${movie.title}") }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        val image: Painter = painterResource(id = movie.poster)
        Image(
            painter = image,
            contentDescription = movie.title,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
    }
}
