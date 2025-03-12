package com.worldline.insa.template.main

import RemoteMovieDataSource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.worldline.insa.template.features.movies.data.repository.MovieRepository
import com.worldline.insa.template.features.movies.domain.usecase.GetMovieDetailUseCase
import com.worldline.insa.template.features.movies.domain.usecase.GetPopularMoviesUseCase
import com.worldline.insa.template.features.movies.ui.screen.MovieDetailScreen
import com.worldline.insa.template.features.movies.ui.screen.MovieListScreen
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailViewModel
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

                val getMovieDetailUseCase = remember { GetMovieDetailUseCase(repository) }
                val detailViewModel = remember { MovieDetailViewModel(getMovieDetailUseCase) }


                NavHost(navController, startDestination = "movieList") {
                    composable("movieList") {
                        MovieListScreen(listViewModel, navController)
                    }
                    composable("movieDetail/{movieId}") { backStackEntry ->
                        val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
                        MovieDetailScreen(detailViewModel, movieId,navController)


                    }
                }
            }
        }
    }
}