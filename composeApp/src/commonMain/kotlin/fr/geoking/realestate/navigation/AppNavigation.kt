package fr.geoking.realestate.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition

import fr.geoking.realestate.ui.screens.DetailsScreen
import fr.geoking.realestate.ui.screens.FavoritesScreen
import fr.geoking.realestate.ui.screens.HomeScreen
import fr.geoking.realestate.ui.screens.ProfileScreen

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
