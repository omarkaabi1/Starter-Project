package com.worldline.insa.template.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.*
import com.worldline.insa.template.features.movies.data.MovieRepository
import com.worldline.insa.template.features.movies.domain.usecase.GetMovieDetailUseCase
import com.worldline.insa.template.features.movies.domain.usecase.GetMovieListUseCase
import com.worldline.insa.template.features.movies.ui.screen.MovieDetailScreen
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailViewModel
import com.worldline.insa.template.features.movies.ui.screen.MovieListScreen
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieListViewModel
import com.worldline.insa.template.ui.theme.TemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateTheme {
                val navController = rememberNavController()
                val repository = remember { MovieRepository() }
                val listViewModel = remember { MovieListViewModel(GetMovieListUseCase(repository)) }

                NavHost(navController, startDestination = "movieList") {
                    composable("movieList") { MovieListScreen(listViewModel, navController) }
                    composable("movieDetail/{movieTitle}") { backStackEntry ->
                        val movieTitle = backStackEntry.arguments?.getString("movieTitle") ?: ""
                        val detailViewModel = remember { MovieDetailViewModel(GetMovieDetailUseCase(repository), movieTitle) }
                        MovieDetailScreen(detailViewModel, navController)
                    }
                }
            }
        }
    }
}
