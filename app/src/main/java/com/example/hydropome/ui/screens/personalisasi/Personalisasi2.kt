package com.example.hydropome.ui.screens.personalisasi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import androidx.compose.ui.Alignment

@Composable
fun Personalisasi2(navController: NavHostController){
    Scaffold (
        contentWindowInsets = WindowInsets(0.dp)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())

        ) {
            Box (
                modifier = Modifier
                    .fillMaxHeight()
            ){
                PersonalisasiCurveHeader()
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Box(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .size(50.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White.copy(alpha = 0.15f))
                                .clickable {
                                    navController.navigate("Personalisasi1")
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.panahkiri),
                                contentDescription = "Icon Panah kiri",
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(190.dp))

                        Text(
                            text = "2/3",
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(vertical = 25.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Button(
                            onClick = { navController.navigate("Main") },
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .width(80.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            )
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.White.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Lewati",
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.height(35.dp))
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(340.dp)
                                .padding(6.dp)
                                .shadow(
                                    elevation = 10.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    clip = false
                                )
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .padding(24.dp)
                        ) {
                            Column {
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
                                        text = "Jenis tanaman apa saja yang ingin kamu tanam?",
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .padding(top = 20.dp)
                                ) {
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Column {

                                        }
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.boxbutton),
                                                contentDescription = "boxButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "Sayuran daun (misalnya selada, bayam)"
                                            )
                                        }

                                    }

                                    Spacer(Modifier.height(8.dp))

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.boxbutton),
                                                contentDescription = "boxButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "Buah (misalnya tomat, stroberi)"
                                            )
                                        }

                                    }

                                    Spacer(Modifier.height(8.dp))

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.boxbutton),
                                                contentDescription = "boxButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "Tanaman herbal"
                                            )
                                        }

                                    }


                                    Spacer(Modifier.height(8.dp))

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.boxbutton),
                                                contentDescription = "boxButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "Belum tahu / ingin rekomendasi"
                                            )
                                        }

                                    }


                                }
                            }

                        }

                    }


                    Spacer(modifier = Modifier.height(10.dp))

                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp)
                                .padding(horizontal = 6.dp)
                                .shadow(
                                    elevation = 10.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    clip = false
                                )
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .padding(24.dp)

                        ) {
                            Column {
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
                                        text = "Berapa  waktu yang bisa diluangkan per hari untuk merawat tanaman?",
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .padding(top = 20.dp)
                                ) {
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Column {

                                        }
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.radiobutton),
                                                contentDescription = "RadioButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "< 10 menit"
                                            )
                                        }

                                    }

                                    Spacer(Modifier.height(8.dp))

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.radiobutton),
                                                contentDescription = "RadioButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "10–30 menit"
                                            )
                                        }

                                    }

                                    Spacer(Modifier.height(8.dp))

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.radiobutton),
                                                contentDescription = "RadioButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "> 30 menit"
                                            )
                                        }

                                    }

                                }
                            }

                        }



                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp)
                                .padding(horizontal = 6.dp)
                                .shadow(
                                    elevation = 10.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    clip = false
                                )
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .padding(24.dp)
                        ) {
                            Column {
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
                                        text = "Di mana kamu akan menanam tanaman hidroponik?",
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                    )
                                }

                                Column(
                                    modifier = Modifier
                                        .padding(top = 20.dp)
                                ) {
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Column {

                                        }
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.radiobutton),
                                                contentDescription = "RadioButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "Dalam ruangan"
                                            )
                                        }

                                    }

                                    Spacer(Modifier.height(8.dp))

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.radiobutton),
                                                contentDescription = "RadioButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "Luar ruangan"
                                            )
                                        }

                                    }

                                    Spacer(Modifier.height(8.dp))

                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(20.dp))
                                    ){
                                        Row (
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF7F8F9)),

                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                painter = painterResource(R.drawable.radiobutton),
                                                contentDescription = "RadioButton",
                                                modifier = Modifier
                                                    .padding(10.dp)
                                                    .size(25.dp)
                                            )

                                            Text(
                                                text = "Balkon atau teras"
                                            )
                                        }

                                    }

                                }
                            }

                        }



                    }


                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF179778))
                    .clickable{
                        navController.navigate("Personalisasi3")
                    },
                contentAlignment = Alignment.Center
            ) {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Selanjutnya",
                    color  = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold

                )
            }
            Spacer(modifier = Modifier
                .height(16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Personalisasi2Preview() {
    Personalisasi2(navController = rememberNavController())
}