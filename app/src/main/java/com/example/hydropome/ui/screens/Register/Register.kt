package com.example.hydropome.ui.screens.Register

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.core.HydropoMeRoutes
import com.example.hydropome.R


@Composable
fun Register(navController: NavController) {
    val gray = Color(0xFFE8ECF4)
    val green = Color(0xFF179778)
    var name by remember {mutableStateOf("")}
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var verifyPass by remember { mutableStateOf( "") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    Scaffold (
        containerColor = Color.White
    ){ paddingValue ->
        Box(
            modifier = Modifier
                .padding(paddingValue)
                .padding(top = 52.dp, start = 20.dp, end = 20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 24.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE2E8F0),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clip(RoundedCornerShape(24.dp))
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                navController.navigate("Login")
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.panahkiri),
                            contentDescription = "Icon Panah kiri",
                            tint = Color(0xFF1F2937),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Daftar Akun dan Mulai Bertani Hidroponik! \uD83C\uDF3F",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight(700),
                        )
                    )
                }

                Spacer(modifier = Modifier
                    .height(20.dp))

                Column(
                ) {
                    Text(
                        text = "Nama Lengkap",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                        )
                    )
                    Spacer(modifier = Modifier
                        .height(8.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = { Text("Masukkan Nama Lengkap") },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = green,
                            unfocusedBorderColor = green,
                            cursorColor = green,
                            focusedContainerColor = Color(0xFFF7F8F9),
                            unfocusedContainerColor = Color(0xFFF7F8F9)
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier
                        .height(20.dp))

                    Text(
                        text = "Email",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                        )
                    )

                    Spacer(modifier = Modifier
                        .height(8.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text("Masukkan Email") },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF179778),
                            unfocusedBorderColor = Color(0xFF179778),
                            cursorColor = Color(0xFF179778),
                            focusedContainerColor = Color(0xFFF7F8F9),
                            unfocusedContainerColor = Color(0xFFF7F8F9)
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email
                        )
                    )

                    Spacer(modifier = Modifier
                        .height(20.dp))

                    Text(
                        text = "Buat Password",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                        )
                    )

                    Spacer(modifier = Modifier
                        .height(8.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
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


                    Spacer(modifier = Modifier
                        .height(20.dp))
                    Text(
                        text = "Konfirmasi Password",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                        )
                    )

                    Spacer(modifier = Modifier
                        .height(8.dp))

                    OutlinedTextField(
                        value = verifyPass,
                        onValueChange = { verifyPass = it },
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


                    Spacer(modifier = Modifier
                        .height(16.dp)
                    )

                    Button(

                        onClick = {
                            when {
                                name.isEmpty() -> {
                                    errorMessage = "Nama tidak boleh kosong"
                                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                }

                                email.isEmpty() -> {
                                    errorMessage = "Email tidak boleh kosong"
                                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                }

                                password.isEmpty() -> {
                                    errorMessage = "Password tidak boleh kosong"
                                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                }

                                verifyPass.isEmpty() -> {
                                    errorMessage = "Konfirmasi password tidak boleh kosong"
                                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                }

                                password != verifyPass -> {
                                    errorMessage = "Password dan konfirmasi tidak cocok"
                                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                }

                                else -> {
                                    navController.navigate(HydropoMeRoutes.Login.routes)
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF179778)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .height(48.dp)
                            .fillMaxWidth()
                    ) {
                        Text("Daftar Akun",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                )
                            )
                    }

                    Spacer(modifier = Modifier
                        .height(16.dp)
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = "Sudah memiliki akun?",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        )
                        Spacer(modifier = Modifier
                            .width(4.dp)
                        )
                        Text(
                            text = "Masuk",
                            color = Color(0xFF179778),
                            style = TextStyle(
                                fontWeight = FontWeight(600),
                            ),
                            modifier = Modifier
                                .clickable(onClick = { navController.navigate(HydropoMeRoutes.Login.routes) })

                        )
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun RegisterPreview() {
    Register(navController = rememberNavController())
}