package fr.geoking.realestate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform