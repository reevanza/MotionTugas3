package com.example.hydropome.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hydropome.R
import com.example.hydropome.ui.screens.Homepage
import com.example.hydropome.ui.screens.MarketPlace
import com.example.hydropome.ui.screens.PantauTanaman
import com.example.hydropome.ui.screens.Profil.Profil

@Composable
fun MainScreen(
    username: String,
    navController: NavController
){
    val items = listOf("Beranda","Pantau Tanaman", "Marketplace", "Profil")
    val selectedIcons = listOf(R.drawable.home_hijau, R.drawable.pohon_hijau, R.drawable.bag_hijau, R.drawable.akunhijau)
    val unselectedIcons = listOf(R.drawable.home_abu, R.drawable.pohon_abu, R.drawable.bag_abu, R.drawable.akunabu)
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold (
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = {
                            Icon(
                                painter = painterResource(
                                    if (selectedItem == index) selectedIcons[index]
                                    else unselectedIcons[index]
                                ),
                                contentDescription = item,
                                tint = Color.Unspecified
                            )
                        },
                        label = {
                            Text(
                                text = item,
                                fontSize = 10.2.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                softWrap = false,
                                modifier = Modifier
                                    .padding(horizontal = 2.dp)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent, // hilangkan background biru
                            selectedIconColor = Color.Unspecified,
                            unselectedIconColor = Color.Unspecified
                        )
                    )
                }
            }
        }
    ){ innerPadding ->
        when (selectedItem) {
            0 -> Homepage(
                username = username,
                innerPadding = innerPadding
            )

            1 -> PantauTanaman(
                username = username,
                innerPadding = innerPadding
            )

            2 -> MarketPlace(
                username = username,
                innerPadding = innerPadding
            )

            3 -> Profil(
                username = username,
                innerPadding = innerPadding,
                navController = navController
            )
        }

    }

}