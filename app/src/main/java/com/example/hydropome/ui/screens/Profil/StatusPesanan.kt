package com.example.hydropome.ui.screens.Profil

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import com.example.hydropome.ui.screens.navigation.Statuspesanan

@Composable
fun StatusPesanan (
    innerPadding: PaddingValues = PaddingValues(),
    navController: NavController
){
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
                        .border(
                            width = 2.dp,
                            color = Color(0xFFE8ECF4),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { navController.navigate("Profil") },
                    contentAlignment = Alignment.Center


                ) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_left),
                        contentDescription = "tombol kembali"
                    )
                }

                Text(
                    text = "Status Pesanan",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center),
                    fontSize = 24.sp
                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ){
                Button(
                    onClick = {

                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF179778)),
                    modifier = Modifier
                        .height(42.dp)
                        .width(88.dp)
                ) {
                    Text(
                        text = "Diproses",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp)
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = {

                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE8F5F2),
                        contentColor = Color(0xFF179778)
                    ),
                    border = BorderStroke(2.dp, Color(0xFF179778)),
                    modifier = Modifier
                        .height(42.dp)
                        .width(88.dp)
                ) {
                    Text(
                        text = "Dikirim",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp)
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = {

                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE8F5F2),
                        contentColor = Color(0xFF179778)
                    ),
                    border = BorderStroke(2.dp, Color(0xFF179778)),
                    modifier = Modifier
                        .height(42.dp)
                        .width(88.dp)
                ) {
                    Text(
                        text = "Selesai",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp)
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp),
                        clip = false
                    )
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(12.dp)

            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.paketlengkap),
                            contentDescription = "paketlengkap",
                            modifier = Modifier
                                .size(90.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(
                                text = "Paket Lengkap",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Row {
                                Text(
                                    text = "Rp 25.000",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF179778)
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Text(
                                    text = "Rp 50.000",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF757575),
                                    textDecoration = TextDecoration.LineThrough
                                )

                            }

                            Spacer(modifier = Modifier.height(18.dp))

                            Text(
                                text = "Jumlah produk: 1pcs",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color(0xFF9C9C9C)
                            )


                        }

                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Divider(
                        color = Color(0xFFEDEDED),
                        thickness = 1.dp
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = "1 produk",
                            color = Color(0xFF9C9C9C),
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "Total:",
                            color = Color(0xFF9C9C9C),
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.width(2.dp))

                        Text(
                            text = "Rp 35.000:",
                            color = Color(0xFF009688),
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                }

            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun StatuspesananPreview() {
    StatusPesanan(navController = rememberNavController())
}