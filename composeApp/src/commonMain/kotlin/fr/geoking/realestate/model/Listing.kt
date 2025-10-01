package com.firebnb.model

data class Listing(
    val id: String,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    val location: String,
    val rating: Double,
    val host: User,
    var isFavorite: Boolean = false
)
