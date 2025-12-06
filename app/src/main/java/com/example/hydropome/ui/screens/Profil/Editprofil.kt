package com.example.hydropome.ui.screens.Profil

import android.text.BoringLayout
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import com.example.hydropome.ui.button.BackButton
import com.example.hydropome.ui.screens.navigation.Editprofil
import com.example.hydropome.ui.screens.navigation.Login
import com.example.hydropome.ui.screens.personalisasi.Personalisasi2

@Composable
fun Editprofil(
    innerPadding: PaddingValues = PaddingValues(),
    navController: NavController
) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var verifyPass by remember { mutableStateOf( "") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())

        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 50.dp, end = 20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .border(width =2.dp, color= Color(0xFFE8ECF4), shape = RoundedCornerShape(12.dp))
                        .clickable{ navController.navigate("Profil") },
                    contentAlignment = Alignment.Center


                ){
                    Icon(
                        painter = painterResource(R.drawable.arrow_left),
                        contentDescription = "tombol kembali"
                    )
                }

                Text(
                    text = "Edit Profil",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center),
                    fontSize = 24.sp
                )

            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ){
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.avatar),
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE8F5F2)),
                        contentScale = ContentScale.Crop,
                    )

                    Icon(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF179778))
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                    )
                }



            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = "Nama Lengkap",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                OutlinedTextField(
                    value = "",
                    onValueChange = {  },
                    placeholder = { Text("Mellafesa") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF179778),
                        unfocusedBorderColor = Color(0xFF179778),
                        cursorColor = Color(0xFF179778),
                        focusedContainerColor = Color(0xFFF7F8F9),
                        unfocusedContainerColor = Color(0xFFF7F8F9)
                    ),
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = "Email",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                OutlinedTextField(
                    value = "",
                    onValueChange = {  },
                    placeholder = { Text("mellafesaa@gmail.com") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF179778),
                        unfocusedBorderColor = Color(0xFF179778),
                        cursorColor = Color(0xFF179778),
                        focusedContainerColor = Color(0xFFF7F8F9),
                        unfocusedContainerColor = Color(0xFFF7F8F9)
                    ),
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = "Password",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Masukkan Password") },
                    visualTransformation = if (confirmPasswordVisible)
                        VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                            Icon(
                                painter = painterResource(
                                    id = if (confirmPasswordVisible)
                                        R.drawable.rounded_visibility_24
                                    else
                                        R.drawable.rounded_visibility_off_24
                                ),
                                contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password"
                            )
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF179778),
                        unfocusedBorderColor = Color(0xFF179778),
                        cursorColor = Color(0xFF179778),
                        focusedContainerColor = Color(0xFFF7F8F9),
                        unfocusedContainerColor = Color(0xFFF7F8F9)
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Ubah Password",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                    )
                )

                Spacer(modifier = Modifier
                    .height(8.dp))

                OutlinedTextField(
                    value = verifyPass,
                    onValueChange = { verifyPass = it },
                    placeholder = { Text("Masukkan Password") },
                    visualTransformation = if (passwordVisible)
                        VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(
                                    id = if (passwordVisible)
                                        R.drawable.rounded_visibility_24
                                    else
                                        R.drawable.rounded_visibility_off_24
                                ),
                                contentDescription = if (passwordVisible) "Hide password" else "Show password"
                            )
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF179778),
                        unfocusedBorderColor = Color(0xFF179778),
                        cursorColor = Color(0xFF179778),
                        focusedContainerColor = Color(0xFFF7F8F9),
                        unfocusedContainerColor = Color(0xFFF7F8F9)
                    )
                )
            }

            Spacer(modifier = Modifier.height(140.dp))

            Button(
                onClick = {
                    navController.navigate("Profil")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF179778)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text("Simpan",
                    style = TextStyle(
                        fontSize = 16.sp,
                    )
                )
            }

        }

    }
}