package com.example.hydropome.ui.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.hydropome.ui.screens.Homepage
import com.example.hydropome.ui.screens.Login
import com.example.hydropome.ui.screens.MarketPlace
import com.example.hydropome.ui.screens.Onboard.Onboard1
import com.example.hydropome.ui.screens.Onboard.Onboard2
import com.example.hydropome.ui.screens.PantauTanaman
import com.example.hydropome.ui.screens.Profil
import com.example.hydropome.ui.screens.Register.Register
import com.example.hydropome.ui.screens.SplashScreen

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
                username = "",
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