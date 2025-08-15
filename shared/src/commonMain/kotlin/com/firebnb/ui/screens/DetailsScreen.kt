package com.firebnb.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.firebnb.model.MockListings

@Composable
fun DetailsScreen(listingId: String) {
    val listing = MockListings.listings.find { it.id == listingId }
    if (listing == null) {
        Text("Listing not found")
        return
    }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = listing.title, style = MaterialTheme.typography.h4)
        Text(text = listing.location, style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = listing.description)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = listing.price, style = MaterialTheme.typography.h6)
    }
}