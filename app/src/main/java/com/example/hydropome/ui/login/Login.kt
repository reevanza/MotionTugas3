package com.example.hydropome.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import com.example.hydropome.ui.button.BackButton



@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun login added
fun Login(navController: NavHostController) {
    var passwordVisible by remember { mutableStateOf(false) }
    var email by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Tidak ada judul */ },
                navigationIcon = {
                    BackButton(
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.padding(start = 12.dp)
            )
        },
        containerColor = Color.White
    ) { innerPadding ->

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),

            verticalArrangement = Arrangement.Top
        ){

            // Spacer untuk memberi jarak dari TopAppBar
            Spacer(Modifier.height(40.dp))

            Text(
                text = "Selamat Datang Kembali HydropoMate! \uD83C\uDF3F\uD83C\uDF43",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,

            )

            Spacer(Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "Email",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700)
                )
            }

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder  = {Text(text="Masukkan Email",
                    fontSize = 12.sp,)},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,

                    focusedContainerColor = Color(0xFFF7F8F9),
                    focusedBorderColor = Color(0xFF179778),
                    cursorColor = Color(0xFF179778),
                    unfocusedContainerColor  = Color(0xFFF7F8F9),
                    unfocusedBorderColor = Color(0xFFE8ECF4),
                    unfocusedLabelColor = Color(0xFF8391A1),
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "Password",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700)
                )
            }

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder  = {Text(text="Masukkan Password",
                    fontSize = 12.sp,
                    )},
                colors = OutlinedTextFieldDefaults.colors(
                    // --- MASALAH 2 DIPERBAIKI ---
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,

                    focusedContainerColor = Color(0xFFF7F8F9),
                    focusedBorderColor = Color(0xFF179778),
                    cursorColor = Color(0xFF179778),
                    unfocusedContainerColor  = Color(0xFFF7F8F9),
                    unfocusedBorderColor = Color(0xFFE8ECF4),
                    unfocusedLabelColor = Color(0xFF8391A1),
                ),
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        R.drawable.eye_closed
                    else
                        R.drawable.eye_open
                    val description = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = description
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,

            ){
                LoginButton(
//                    modifier = Modifier
//                        .align(Alignment.CenterVertically)

                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login(navController = rememberNavController())
}