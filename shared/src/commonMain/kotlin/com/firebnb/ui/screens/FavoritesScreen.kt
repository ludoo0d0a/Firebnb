package com.firebnb.ui.screens

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
import cafe.adriel.voyager.core.screen.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.firebnb.data.ListingRepositoryImpl
import com.firebnb.navigation.DetailsScreen
import com.firebnb.presentation.viewmodel.FavoritesViewModel
import com.firebnb.ui.components.ListingItem

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
