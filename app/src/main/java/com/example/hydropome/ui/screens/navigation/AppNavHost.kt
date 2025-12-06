package com.example.hydropome.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hydropome.ui.screens.homepage.Homepage
import com.example.hydropome.ui.screens.login.Login
import com.example.hydropome.ui.screens.marketplace.MarketPlace
import com.example.hydropome.ui.screens.Onboard.Onboard1
import com.example.hydropome.ui.screens.Onboard.Onboard2
import com.example.hydropome.ui.screens.Profil.Profil
import com.example.hydropome.ui.screens.Profil.Editprofil
import com.example.hydropome.ui.screens.Profil.StatusPesanan
import com.example.hydropome.ui.screens.Register.Register
import com.example.hydropome.ui.screens.homepage.LamanTanaman
import com.example.hydropome.ui.screens.pantautanaman.PantauTanamanList
import com.example.hydropome.ui.screens.pantautanaman.PantauTanamanTask
import com.example.hydropome.ui.screens.personalisasi.Personalisasi1
import com.example.hydropome.ui.screens.personalisasi.Personalisasi2
import com.example.hydropome.ui.screens.personalisasi.Personalisasi3
import com.example.hydropome.ui.screens.splashscreen.SplashScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Main"
    ){
        composable("Login") {
            Login(
                navController = navController
            )
        }
        composable("PantauTanamanTask") {
            PantauTanamanTask(
                navController = navController
            )
        }
        composable("PantauTanamanList") {
            PantauTanamanList(
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
                navController = navController,
                username = ""
            )
        }


        composable("LamanTanaman") {
            LamanTanaman(
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

        composable("Editprofil") {
            Editprofil(
                navController = navController
            )
        }

        composable("StatusPesanan") {
            StatusPesanan(
                navController = navController
            )
        }

        composable("Personalisasi1") {
            Personalisasi1(
                navController = navController
            )
        }

        composable("Personalisasi2") {
            Personalisasi2(
                navController = navController
            )
        }

        composable("Personalisasi3") {
            Personalisasi3(
                navController = navController
            )
        }

        composable("Main?index={index}",
            arguments = listOf(
                navArgument("index"){
                    type = NavType.IntType
                             defaultValue = 0})
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0 //ambil angka yg diminta
            MainScreen(
                username = "",
                navController = navController,
                initialIndex = index
            )
        }
    }
}

