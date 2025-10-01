package com.firebnb.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition

import com.firebnb.ui.screens.DetailsScreen
import com.firebnb.ui.screens.FavoritesScreen
import com.firebnb.ui.screens.HomeScreen
import com.firebnb.ui.screens.ProfileScreen

object FavoritesScreen : Screen {
    @Composable
    override fun Content() {
        FavoritesScreen()
    }
}

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        HomeScreen()
    }
}

data class DetailsScreen(val listingId: String) : Screen {
    @Composable
    override fun Content() {
        DetailsScreen(listingId)
    }
}

object ProfileScreen : Screen {
    @Composable
    override fun Content() {
        ProfileScreen()
    }
}

@Composable
fun AppNavigation() {
    Navigator(HomeScreen) { navigator ->
        SlideTransition(navigator)
    }
}
