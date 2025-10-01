package com.firebnb.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.firebnb.data.ListingRepositoryImpl
import com.firebnb.navigation.DetailsScreen
import com.firebnb.presentation.viewmodel.HomeViewModel
import com.firebnb.ui.components.ListingItem

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
