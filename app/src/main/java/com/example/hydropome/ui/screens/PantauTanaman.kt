package com.example.hydropome.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.ui.navigation.BottomNavBar

@Composable
fun PantauTanaman(navController: NavHostController){
    val green = Color(0xFF179778)
    
    Scaffold(
        bottomBar = { BottomNavBar(navController = navController, pages = 1) }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun PantauPreview() {
    PantauTanaman(navController = rememberNavController())
}