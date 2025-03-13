package com.worldline.insa.template.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.worldline.insa.template.features.movies.ui.screen.MovieDetailScreen
import com.worldline.insa.template.features.movies.ui.screen.MovieListScreen
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieDetailViewModel
import com.worldline.insa.template.features.movies.ui.viewmodel.MovieListViewModel
import com.worldline.insa.template.ui.theme.TemplateTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val listViewModel : MovieListViewModel by viewModel()
    private val  detailViewModel : MovieDetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { NavigationBar(navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "movieList",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("movieList") {
                            MovieListScreen(listViewModel, navController)
                        }
                        composable("movieDetail/{movieId}") { backStackEntry ->
                            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
                            MovieDetailScreen(detailViewModel, movieId, navController)
                        }
                        composable("favorites") {}
                    }
                }
            }
        }
    }

}


    @Composable
    fun NavigationBar(navController: NavController) {
        val items = listOf(
            BottomNavItem("movieList", Icons.Default.DateRange, "Movies"),
            BottomNavItem("favorites", Icons.Default.Favorite, "Favorites")
        )

        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, contentDescription = item.label) },
                    label = { Text(item.label) },
                    selected = false,
                    onClick = { navController.navigate(item.route) }
                )
            }
        }
    }

    data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)



