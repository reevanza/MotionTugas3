package com.example.hydropome.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.ui.screens.homepage.Homepage
import com.example.hydropome.ui.screens.login.Login
import com.example.hydropome.ui.screens.marketplace.MarketPlace
import com.example.hydropome.ui.screens.Onboard.Onboard1
import com.example.hydropome.ui.screens.Onboard.Onboard2
import com.example.hydropome.ui.screens.pantautanaman.PantauTanaman
import com.example.hydropome.ui.screens.Profil.Profil
import com.example.hydropome.ui.screens.Register.Register
import com.example.hydropome.ui.screens.personalisasi.Personalisasi1
import com.example.hydropome.ui.screens.splashscreen.SplashScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "SplashScreen"
    ){
        composable("Login") {
            Login(
                navController = navController
            )
        }

        composable("Register") {
            Register(
                navController = navController
            )
        }

        composable("Onboard1") {
            Onboard1(
                navController = navController
            )
        }

        composable("Onboard2") {
            Onboard2(
                navController = navController
            )
        }

        composable("SplashScreen") {
            SplashScreen(
                navController = navController
            )
        }

        composable("Homepage") {
            Homepage(
                username = "",
            )
        }

        composable("PantauTanaman") {
            PantauTanaman(
                navController = navController
            )
        }

        composable("MarketPlace") {
            MarketPlace(
                username = "",
            )
        }

        composable("Profil") {
            Profil(
                username = "",
                navController = navController
            )
        }

        composable("Personalisasi1") {
            Personalisasi1(
                navController = navController
            )
        }

        composable("Main") {
            MainScreen(
                username = "",
                navController = navController
            )
        }
    }
}