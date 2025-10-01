package fr.geoking.realestate.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import fr.geoking.realestate.data.ListingRepositoryImpl
import fr.geoking.realestate.navigation.DetailsScreen
import fr.geoking.realestate.presentation.viewmodel.FavoritesViewModel
import fr.geoking.realestate.ui.components.ListingItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen() {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel = rememberScreenModel { FavoritesViewModel(ListingRepositoryImpl()) }
    val listings by viewModel.listings.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorites") },
                navigationIcon = {
                    IconButton(onClick = { navigator.pop() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(listings) { listing ->
                ListingItem(
                    listing = listing,
                    onListingClick = { navigator.push(DetailsScreen(listing.id)) },
                    onFavoriteClick = { viewModel.toggleFavorite(listing.id) }
                )
            }
        }
    }
}

@Preview
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}
