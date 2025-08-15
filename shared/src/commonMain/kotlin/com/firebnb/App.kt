package com.firebnb

import androidx.compose.runtime.Composable
import com.firebnb.navigation.Screen
import com.firebnb.ui.screens.HomeScreen
import com.firebnb.ui.screens.DetailsScreen

@Composable
fun FirebnbApp(startDestination: String = Screen.Home.route, deepLinkListingId: String? = null) {
    // Use Compose Navigation (Accompanist or official) here.
    // For brevity, navigation is stubbed.
    // Use Navigation Compose for Android, custom for iOS.
    if (deepLinkListingId != null) {
        DetailsScreen(listingId = deepLinkListingId)
    } else {
        HomeScreen(onListingClick = { /* Navigate to DetailsScreen with listingId */ })
    }
}