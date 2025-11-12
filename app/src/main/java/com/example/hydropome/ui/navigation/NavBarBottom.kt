package com.example.hydropome.ui.navigation

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Home
import com.example.hydropome.R
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.core.HydropoMeRoutes

@Composable

fun BottomNavBar(navController: NavController, pages: Int = 0) {
    val menuItems = listOf(
        Triple(HydropoMeRoutes.Homepage,Icons.Filled.Home, Icons.Outlined.Home) to "Beranda",
        Triple(HydropoMeRoutes.PantauTanaman, R.drawable.pantautanamanhijau, R.drawable.pantautanamanabu)to "Pantau Tanaman",
        Triple(HydropoMeRoutes.MarketPlace, R.drawable.marketplacehijau, R.drawable.marketplaceabu) to "Marketplace",
        Triple(HydropoMeRoutes.Profil, R.drawable.akunhijau, R.drawable.akunabu) to "Profil"


    )
    NavigationBar(
        containerColor = Color.White
    ) {
        menuItems.forEachIndexed { index, item ->
            val (routeIcons, label) = item
            val (route, filledIcon, outlineIcon) = routeIcons
            val selected = pages == index

            NavigationBarItem(
                icon = {
                    if (filledIcon is ImageVector) {
                        Icon(
                            imageVector = if (selected) filledIcon else outlineIcon as ImageVector,
                            contentDescription = "icon"
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = if (selected) filledIcon as Int else outlineIcon as Int),
                            contentDescription = "icon"
                        )
                    }
                }
                ,
                colors = NavigationBarItemColors(
                    selectedIconColor = Color(0xFF179778),
                    selectedTextColor = Color(0xFF179778),
                    selectedIndicatorColor = Color.Unspecified,
                    unselectedIconColor = Color(0xFF98A0AA),
                    unselectedTextColor = Color(0xFF98A0AA),
                    disabledIconColor = Color.Unspecified,
                    disabledTextColor = Color.Unspecified,
                ),
                label = {
                    Text(
                        text = label,
                        maxLines = 1,
                        softWrap = false,
                        fontSize = 10.sp
                    )
                },
                selected = pages == index,
                onClick = {
                    navController.navigate(route.routes) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}