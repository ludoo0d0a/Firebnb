package com.firebnb.data

import com.firebnb.model.Listing
import com.firebnb.model.User

object MockData {
    private val users = listOf(
        User("1", "John Doe", "https://randomuser.me/api/portraits/men/1.jpg"),
        User("2", "Jane Smith", "https://randomuser.me/api/portraits/women/2.jpg")
    )

    val listings = listOf(
        Listing(
            "1",
            "Cozy Apartment in the City Center",
            "This is a beautiful apartment located in the heart of the city. It is close to all major attractions and is perfect for a weekend getaway.",
            100,
            "https://picsum.photos/seed/1/800/600",
            "New York, NY",
            4.5,
            users[0]
        ),
        Listing(
            "2",
            "Spacious Villa with a Pool",
            "This is a luxurious villa with a private pool. It is perfect for a family vacation.",
            300,
            "https://picsum.photos/seed/2/800/600",
            "Los Angeles, CA",
            4.8,
            users[1]
        ),
        Listing(
            "3",
            "Charming Cottage in the Countryside",
            "This is a cozy cottage located in the countryside. It is perfect for a romantic getaway.",
            150,
            "https://picsum.photos/seed/3/800/600",
            "San Francisco, CA",
            4.9,
            users[0]
        ),
        Listing(
            "4",
            "Modern Loft with a View",
            "This is a modern loft with a stunning view of the city. It is perfect for a business trip.",
            200,
            "https://picsum.photos/seed/4/800/600",
            "Chicago, IL",
            4.7,
            users[1]
        )
    )
}
