package com.example.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.ui.R
import com.example.ui.viewmodel.MovieDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(viewModel: MovieDetailViewModel, movieId: Int, navController: NavController) {
    val movie by viewModel.movieDetail.collectAsState()

    LaunchedEffect(movieId) {
        viewModel.fetchMovieDetails(movieId)
    }


    movie?.let {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(it.title) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                painter = painterResource(R.drawable.img),
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = it.posterPath),
                    contentDescription = it.title,
                    modifier = Modifier.size(180.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.overview, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Note : ${it.voteAverage}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

