package com.example.hydropome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.hydropome.ui.screens.navigation.AppNavHost
import com.example.hydropome.ui.theme.HydropoMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HydropoMeTheme {
                AppNavHost()
            }
        }
    }
}