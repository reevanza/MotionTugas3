package com.example.hydropome.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.core.HydropoMeRoutes
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hydropome.ui.screens.Homepage
import com.example.hydropome.ui.screens.Login
import com.example.hydropome.ui.screens.MarketPlace
import com.example.hydropome.ui.screens.SplashScreen
import com.example.hydropome.ui.screens.Onboard.Onboard1
import com.example.hydropome.ui.screens.Onboard.Onboard2
import com.example.hydropome.ui.screens.PantauTanaman
import com.example.hydropome.ui.screens.Profil
import com.example.hydropome.ui.screens.Register


@Composable
fun Navigation (navController: NavHostController){
//    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = HydropoMeRoutes.SplashScreen.routes
    ){
        composable(
            HydropoMeRoutes.SplashScreen.routes
        ){
            SplashScreen(navController)
        }
        composable(
            HydropoMeRoutes.Onboard1.routes
        ){
            Onboard1(navController)
        }
        composable(
            HydropoMeRoutes.Onboard2.routes
        ){
            Onboard2(navController)
        }
        composable(
            HydropoMeRoutes.Login.routes
        ){
            Login(navController)
        }
        composable(
            HydropoMeRoutes.Register.routes
        ){
            Register(navController)
        }
        composable(
            HydropoMeRoutes.Homepage.routes
        ){
            Homepage(navController)
        }
        composable(
            HydropoMeRoutes.PantauTanaman.routes
        ){
            PantauTanaman(navController)
        }
        composable(
            HydropoMeRoutes.MarketPlace.routes
        ){
            MarketPlace(navController)
        }
        composable(
            HydropoMeRoutes.Profil.routes
        ){
            Profil(navController)
        }
    }
}