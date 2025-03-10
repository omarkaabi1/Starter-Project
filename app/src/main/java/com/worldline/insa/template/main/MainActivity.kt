package com.worldline.insa.template.main

import RemoteMovieDataSource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.domain.usecase.GetPopularMoviesUseCase
import com.worldline.insa.template.features.movies.ui.screen.MovieListScreen
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieListViewModel
import com.worldline.insa.template.ui.theme.TemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateTheme {
                val navController = rememberNavController()
                val remoteDataSource = remember { RemoteMovieDataSource() }
                val repository = remember { MovieRepository(remoteDataSource) }
                val getPopularMoviesUseCase = remember { GetPopularMoviesUseCase(repository) }
                val listViewModel = remember { MovieListViewModel(getPopularMoviesUseCase) }


                NavHost(navController, startDestination = "movieList") {
                    composable("movieList") {
                        MovieListScreen(listViewModel, navController)
                    }
                    composable("movieDetail/{movieTitle}") { backStackEntry ->
                        val movieTitle = backStackEntry.arguments?.getString("movieTitle") ?: ""
                        //MovieDetailScreen(movieTitle)
                    }
                }
            }
        }
    }
}