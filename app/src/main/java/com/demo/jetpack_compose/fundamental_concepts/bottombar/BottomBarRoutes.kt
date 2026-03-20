package com.demo.jetpack_compose.fundamental_concepts.bottombar

import kotlinx.serialization.Serializable


sealed class BottomBarRoutes {
    @Serializable
    object Home : BottomBarRoutes()

    @Serializable
    object Wishlist : BottomBarRoutes()

    @Serializable
    object Cart : BottomBarRoutes()

    @Serializable
    object Profile : BottomBarRoutes()
}