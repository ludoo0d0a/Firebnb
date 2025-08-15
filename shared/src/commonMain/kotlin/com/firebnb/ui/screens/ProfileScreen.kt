package com.firebnb.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.firebnb.navigation.FavoritesScreen

@Composable
fun ProfileScreen() {
    val navigator = LocalNavigator.currentOrThrow

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { navigator.push(FavoritesScreen) }) {
            Text("Go to Favorites")
        }
    }
}
