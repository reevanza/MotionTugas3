package com.example.hydropome.ui.screens.pantautanaman

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import com.example.hydropome.ui.button.BackButton
import com.example.hydropome.ui.screens.shape.BottomArcShape
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantauTanamanTask(navController: NavController) {
    // State untuk UI
    var selectedIndex by remember { mutableIntStateOf(0) } // Default hari ke-1
    var selectedBox by remember { mutableStateOf(false) } // State checkbox sederhana
    var showPopUp by remember {mutableStateOf(false)}
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Pantau Tanaman",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black,

                    )
                },
                navigationIcon = {
                    BackButton(
                        modifier = Modifier
                            .clickable(onClick = { navController.popBackStack() })
                            .padding(start = 8.dp),

                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        //logic pop up
        if(showPopUp){
            androidx.compose.ui.window.Dialog(
                onDismissRequest = {showPopUp = false} //kalo klik luar popup, popup ilang
            ) {
                PopupSelesai(
                    onDismiss = {
                        showPopUp = false
                    },
                    onNext = {
                        showPopUp = false //belum diubah logic untuk ke next hari
                    }

                )
            }
        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF8F9FA)) // Background abu sangat muda biar shadow kelihatan
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(219.dp)
                    .background(Color.White),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(R.drawable.sayur),
                    contentDescription = "foto sayur",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(BottomArcShape()), // Pastikan file BottomArcShape aman
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp) // Padding bawah biar scroll ga mentok
            ) {
                // Judul Halaman
                Text(
                    text = "Selada Hidroponik",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 25.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Info (Mudah, Hari ke-1)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 25.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.bulethijau), // Pastikan icon ada
                        contentDescription = null,
                        tint = Color(0xFF179778),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Mudah",
                        fontSize = 16.sp,
                        color = Color(0xFF179778)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(
                        painter = painterResource(R.drawable.pohon_hijau), // Pastikan icon ada
                        contentDescription = null,
                        tint = Color(0xFF179778),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Hari ke-1",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                        .fillMaxWidth()
                        .height(140.dp) // Tinggi agak dilonggarkan biar lega
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(top = 12.dp, start = 12.dp, end = 11.dp) // Padding dalam kartu
                ) {
                    Row(modifier = Modifier.fillMaxSize()) {

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end=0.dp)
//                                .width(214.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "Progres menanam",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Ayo mulai menanam!",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(12.dp))

                            val dataProgress = 0.0f //

                            LinearProgressIndicator(
                                // Trik: Kalau 0, kasih 0.01 biar ada titik, kalau lebih pakai asli
                                progress = { if (dataProgress <= 0f) 0.01f else dataProgress },
                                modifier = Modifier
                                    .width(214.dp)
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(50)),
                                color = Color(0xFFFB9A23),
                                trackColor = Color(0xFFFFF5E9),
                                strokeCap = StrokeCap.Round, // Ujung bulat
                                drawStopIndicator = {} // Matikan kotak aneh di ujung kanan
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "${(dataProgress * 100).toInt()}% Selesai",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFFB9A23)
                            )
                        }

                        // Gambar Pohon di Kanan
                        Image(
                            painter = painterResource(id = R.drawable.pohon),
                            contentDescription = "Icon Tanaman",
                            modifier = Modifier
                                .fillMaxHeight(),
                            alignment = Alignment.BottomEnd,
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 25.dp), // Padding start/end list
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(8) { index ->
                        DaysCard(
                            index = index,
                            isCardSelected = (selectedIndex == index),
                            onClick = { selectedIndex = index }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // checklist task nya
                val taskList = listOf(
                    "Siapkan Nutrisi & Air 🧪",
                    "Rendam Rockwool 🧼",
                    "Tanam Benih Selada 🌱",
                    "Tutup & Simpan ☁️"
                )

                Box(
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                        .fillMaxWidth()
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "📌 Tugas Hari ke-1",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        taskList.forEach { taskTitle ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                                    Checkbox(
                                        checked = selectedBox,
                                        onCheckedChange = { selectedBox = it },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color(0xFF179778),
                                            uncheckedColor = Color.Gray,
                                            checkmarkColor = Color.White
                                        ),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(4.dp)) // Jarak kotak ke teks

                                Text(
                                    text = taskTitle,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(R.drawable.plant_kecil),
                                contentDescription = null,
                                tint = Color(0xFF179778),
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Tips Hari Ini:",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Gunakan air tanpa kaporit untuk hasil terbaik!",
                            fontSize = 12.sp,
                            color = Color.DarkGray,
                            lineHeight = 18.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .width(335.dp)
                        .height(190.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFFFA726))
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.banner_iklan),
                        contentDescription = "Background Banner",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start
                    ) {

                        Box(
                            modifier = Modifier
                                .background( Color(0xFFFBAE4F), RoundedCornerShape(50),)
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Belum punya alat dan bahan?",
                                fontSize = 12.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Text(
                            text = "Kunjungi\nMarketplace\nHydroPoMe!",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 22.sp // Jarak antar baris
                        )

                        Button(
                            onClick = { /* Aksi Klik */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF179778) // Warna Hijau
                            ),
                            shape = RoundedCornerShape(50), // Tombol bulat
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                            modifier = Modifier
                                .height(32.dp) // Tinggi tombol
                        ) {
                            Text(
                                text = "Belanja Sekarang",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }


                    }
                }
                Spacer(modifier = Modifier.height(38.dp))

                Button(
                    onClick = {
                        navController.navigate("LamanTanaman")
                    },

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE8F5F2), // Background
                        contentColor = Color(0xFF179778)    // Warna Teks
                    ),

                    border = BorderStroke(1.dp, Color(0xFF179778)),
                    shape = RoundedCornerShape(12.dp),

                    modifier = Modifier
                        .width(335.dp)
                        .height(48.dp)
                        .align(Alignment.CenterHorizontally)

                ) {
                    Text(
                        text = "Lihat Panduan",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,

                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = { showPopUp = true },

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF179778), // Background
                        contentColor = Color.White    // Warna Teks
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(335.dp)
                        .height(48.dp)
                        .align(Alignment.CenterHorizontally)

                ) {
                    Text(
                        text = "Hari Ke-1 Selesai",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }

            }
        }
    }
}

@Composable
fun DaysCard(index: Int, isCardSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isCardSelected) Color(0xFF179778) else Color(0xFFE8F5F2),
        label = "bgColor"
    )
    val contentColor = if (isCardSelected) Color.White else Color(0xFF179778)

    Box(
        modifier = Modifier
            .width(54.dp)
            .height(70.dp) // Sedikit tinggikan biar lega
            .clip(RoundedCornerShape(50)) // Bentuk kapsul
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hari",
                fontSize = 10.sp, // Ukuran font aman
                color = contentColor,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            )
            Text(
                text = if (index < 9) "0${index + 1}" else "${index + 1}",
                fontSize = 14.sp,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Visible
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PantauTanamanTaskPreview() {
    PantauTanamanTask(navController = rememberNavController())
}