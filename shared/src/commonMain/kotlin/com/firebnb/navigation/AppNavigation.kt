package com.firebnb.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{listingId}") {
        fun createRoute(listingId: String) = "details/$listingId"
    }
    object Profile : Screen("profile")
}

object DeepLinks {
    const val LISTING_DETAILS = "firebnb://listing/{listingId}"
    const val PROFILE = "firebnb://profile"
}