package com.example.hydropome.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login
@Serializable
object Register

@Serializable
object Onboard1

@Serializable
object Onboard2

@Serializable
object Homepage

@Serializable
object MarketPlace

@Serializable
object PantauTanaman

@Serializable
object Profil

@Serializable
object SplashScreen



@Serializable
data class Main(
    val username: String
)