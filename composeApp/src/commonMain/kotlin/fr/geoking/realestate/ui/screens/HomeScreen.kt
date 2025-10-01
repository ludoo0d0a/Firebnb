package fr.geoking.realestate.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import fr.geoking.realestate.data.ListingRepositoryImpl
import fr.geoking.realestate.navigation.DetailsScreen
import fr.geoking.realestate.presentation.viewmodel.HomeViewModel
import fr.geoking.realestate.ui.components.ListingItem

@Composable
fun HomeScreen() {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel = rememberScreenModel { HomeViewModel(ListingRepositoryImpl()) }
    val listings by viewModel.listings.collectAsState()

    LazyColumn {
        items(listings) { listing ->
            ListingItem(
                listing = listing,
                onListingClick = { navigator.push(DetailsScreen(listing.id)) },
                onFavoriteClick = { viewModel.toggleFavorite(listing.id) }
            )
        }
    }
}
