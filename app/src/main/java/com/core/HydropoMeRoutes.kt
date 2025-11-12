package com.core

sealed class HydropoMeRoutes (val routes: String) {
    object SplashScreen: HydropoMeRoutes("SplashScreen")
    object Onboard1: HydropoMeRoutes("Onboard1")
    object Onboard2: HydropoMeRoutes("Onboard2")
    object Login: HydropoMeRoutes("login")
    object Register: HydropoMeRoutes("register")
    object Homepage: HydropoMeRoutes("Homepage")
    object PantauTanaman: HydropoMeRoutes("PantauTanaman")
    object MarketPlace: HydropoMeRoutes("MarketPlace")
    object Profil: HydropoMeRoutes("Profil")
}