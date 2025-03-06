package com.worldline.insa.template.features.movies.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.worldline.insa.template.R
import com.worldline.insa.template.features.movies.data.model.Movie
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailState
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(viewModel: MovieDetailViewModel, navController: NavController) {
    val detailState by viewModel.movie.collectAsState()

    detailState.let {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        MovieDetailTitle(it)
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(painter = painterResource(R.drawable.img), contentDescription = "Back")
                        }
                    }
                )
            }
        ) {
            MovieDetailContent(detailState)
        }
    }
}

@Composable
private fun MovieDetailTitle(
    state: MovieDetailState
) {
    when (state) {
        is MovieDetailState.Loading -> Text(text = stringResource(R.string.movie_detail_loading_title))
        is MovieDetailState.Error -> Text(text = stringResource(R.string.movie_detail_error_title))
        is MovieDetailState.Success -> Text(text = state.movie.title, style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
private fun MovieDetailContent(
    detailState: MovieDetailState
) {

    when (detailState) {
        is MovieDetailState.Loading -> MovieLoading()
        is MovieDetailState.Error -> MovieDetailError()
        is MovieDetailState.Success -> MovieContent(detailState.movie)
    }
}

@Composable
private fun MovieDetailError() {
    Text(text = stringResource(R.string.movie_detail_error_details))
}

@Composable
private fun MovieLoading() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator()
    }
}

@Composable
private fun MovieContent(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(movie.poster),
            contentDescription = movie.title,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = movie.title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.description, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.movie_detail_actors_label), style = MaterialTheme.typography.titleMedium)
        movie.actors.forEach { actor ->
            Text(text = "- $actor", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun MovieDetailScreenPreview() {
    val movie = Movie(
        title = "Inception",
        poster = R.drawable.inception,
        description = "A mind-bending thriller",
        actors = listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt")
    )
    MovieContent(movie)
}

@Preview
@Composable
fun MovieDetailErrorPreview() {
    MovieDetailError()
}

@Preview
@Composable
fun MovieLoadingPreview() {
    MovieLoading()
}


