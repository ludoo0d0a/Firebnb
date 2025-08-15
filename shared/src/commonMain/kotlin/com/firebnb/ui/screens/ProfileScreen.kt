package com.firebnb.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Your Profile", modifier = Modifier.padding(bottom = 16.dp))
        // Add more UI elements for profile preview here
        Text(text = "Name: John Doe")
        Text(text = "Email: johndoe@example.com")
    }
}