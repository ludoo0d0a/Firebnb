package com.firebnb.model

data class Listing(
    val id: String,
    val title: String,
    val location: String,
    val imageUrl: String,
    val price: String,
    val description: String
)

object MockListings {
    val listings = listOf(
        Listing(
            id = "1",
            title = "Modern Loft in Paris",
            location = "Paris, France",
            imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb",
            price = "€120/night",
            description = "Enjoy a stylish experience at this centrally-located loft."
        ),
        Listing(
            id = "2",
            title = "Beach House",
            location = "Nice, France",
            imageUrl = "https://images.unsplash.com/photo-1465101178521-5a8b9dc47a1b",
            price = "€180/night",
            description = "Wake up to the sound of waves in this cozy beach house."
        ),
        Listing(
            id = "3",
            title = "Mountain Cabin",
            location = "Chamonix, France",
            imageUrl = "https://images.unsplash.com/photo-1512918728675-ed5a9ecdebfd",
            price = "€90/night",
            description = "Get away from it all in this scenic mountain cabin."
        )
    )
}