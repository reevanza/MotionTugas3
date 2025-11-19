package com.example.hydropome.ui.screens.Profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hydropome.R
import java.time.format.TextStyle


@Composable
fun Profil(
    username: String,
    innerPadding: PaddingValues = PaddingValues(),
    navController: NavController
) {
    Scaffold (
        contentWindowInsets = WindowInsets(0.dp)
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())

        ) {
            Box {
                CurveHeader()

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 84.dp ),
                    horizontalAlignment = Alignment.Start
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(start = 16.dp, end = 16.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.avatar),
                                contentDescription = "Avatar",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(Color.White),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column() {
                                Text(
                                    text = "Mellafesa",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White)
                                Text(
                                    text ="Melafesa@gm,ail.com",
                                    fontSize = 14.sp,
                                    color = Color.White.copy(alpha = 0.8f))
                            }

                            Spacer(modifier = Modifier.width(40.dp))

                            Button(
                                onClick = {  },
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF179778)),
                                modifier = Modifier
                                    .height(42.dp)
                                    .width(102.dp)
                            ) {
                                Text("Edit Profil", fontSize = 12.sp)
                            }
                    }


                    }

                    Spacer(modifier = Modifier.height(84.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(20.dp),
                                clip = false
                            )
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.White)
                            .padding(24.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Status Pesanan Marketplace",
                                fontWeight = FontWeight.ExtraBold
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Box(
                                        ) {
                                            Icon(
                                                painter = painterResource( R.drawable.ic_diproses),
                                                contentDescription = "Diproses",
                                                tint = Color(color = 0xFF179778),
                                                modifier = Modifier.size(40.dp)
                                            )
                                        }
                                        Spacer(Modifier.height(8.dp))
                                        Text(
                                            text = "Diproses",
                                        )
                                    }


                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Box(
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.ic_dikirim),
                                                contentDescription = "Dikirim",
                                                tint = Color(color = 0xFF179778),
                                                modifier = Modifier.size(40.dp)
                                            )
                                        }
                                        Spacer(Modifier.height(8.dp))
                                        Text(
                                            text = "Dikirim",
                                        )
                                    }

                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Box(

                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.ic_selesai),
                                                contentDescription = "Selesai",
                                                tint = Color(color = 0xFF179778),
                                                modifier = Modifier.size(40.dp)
                                            )
                                        }
                                        Spacer(Modifier.height(8.dp))
                                        Text(
                                            text = "Selesai",
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(16.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(10.dp),
                                clip = false
                            )
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .padding(24.dp)
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(140.dp))
                                    .background(Color(color = 0xFFE8F5F2))
                            ){
                                Icon(
                                    painter = painterResource(R.drawable.pohon_hijau),
                                    contentDescription = "Personalisasi",
                                    tint = Color(color = 0xFF179778),
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .size(25.dp)
                                )
                            }

                            Spacer(Modifier.width(8.dp))

                            Text(
                                text = "Personalisasi",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp
                            )

                            Box(

                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.panahkanan),
                                    contentDescription = "Personalisasi",
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }

                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(16.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(10.dp),
                                clip = false
                            )
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .padding(24.dp)
                            .clickable{
                                navController.navigate("Onboard1")
                            }
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(140.dp))
                                    .background(Color(color = 0xFFFFF0F0))
                            ){
                                Icon(
                                    painter = painterResource(R.drawable.ic_logout),
                                    contentDescription = "Logout",
                                    tint = Color(color = 0xFFFC4343),
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .size(25.dp)
                                )
                            }

                            Spacer(Modifier.width(8.dp))

                            Text(
                                text = "Logout",
                                color = Color(0xFFFC4343),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.panahkanan),
                                    contentDescription = "Logout",
                                    tint = Color(color = 0xFFFC4343),
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }

                        }
                    }

                }

            }
        }
    }
}