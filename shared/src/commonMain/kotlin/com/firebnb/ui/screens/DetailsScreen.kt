package com.firebnb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.compose.AsyncImage
import com.firebnb.data.ListingRepositoryImpl
import com.firebnb.presentation.viewmodel.DetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(listingId: String) {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel = rememberScreenModel { DetailsViewModel(ListingRepositoryImpl(), listingId) }
    val listing by viewModel.listing.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Listing Details") },
                navigationIcon = {
                    IconButton(onClick = { navigator.pop() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        listing?.let {
            Column(modifier = Modifier.padding(padding)) {
                AsyncImage(
                    model = it.imageUrl,
                    contentDescription = it.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f)
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(it.title, style = MaterialTheme.typography.titleLarge)
                    Text(it.location, style = MaterialTheme.typography.bodyLarge)
                    Text(it.description, style = MaterialTheme.typography.bodyMedium)
                    Text("$${it.price}/night", style = MaterialTheme.typography.headlineSmall)
                }
            }
        }
    }
}
