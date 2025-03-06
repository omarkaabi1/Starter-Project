package com.worldline.insa.template.features.movies.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.worldline.insa.template.R
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(viewModel: MovieDetailViewModel, navController: NavController) {
    val movie by viewModel.movie.collectAsState()

    movie?.let {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(it.title) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(painter = painterResource(R.drawable.img), contentDescription = "Back")
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
                    painter = painterResource(it.poster),
                    contentDescription = it.title,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.description, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Actors:", style = MaterialTheme.typography.titleMedium)
                it.actors.forEach { actor ->
                    Text(text = "- $actor", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

