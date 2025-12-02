package com.example.hydropome.ui.screens.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // Import all layout
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
// Pastikan import BottomArcShape benar sesuai package kamu
import com.example.hydropome.ui.screens.shape.BottomArcShape

@Composable
fun Homepage(
    navController: NavController,
    username: String,
    innerPadding: PaddingValues = PaddingValues()
) {
    Scaffold(
        modifier = Modifier.padding(innerPadding)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            // --- BAGIAN HEADER (HIJAU) ---
            item {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Kurva Hijau
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(219.dp)
                            .background(
                                Color(0xFF093731),
                                shape = BottomArcShape()
                            ),
                    )
                    // Konten Header (Text & Avatar)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 28.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                                .height(60.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Halo $username! 👋🏻",
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Berkebun Apa Hari Ini?",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.avatar), // Pastikan ada di drawables
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(41.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        //kotak sebelum search bar
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 25.dp)
                                .fillMaxWidth()
                                .height(177.dp) // Tinggi agak dilonggarkan biar lega
                                .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
                                .background(Color.White, shape = RoundedCornerShape(16.dp))
                                .padding(top = 12.dp, start = 12.dp, end = 11.dp) // Padding dalam kartu
                        ) {
                            Row(modifier = Modifier.fillMaxSize()) {

                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end=0.dp)
                                        .align(Alignment.CenterVertically)
                                ) {
                                    Text(
                                        text = "Belum Ada Progress\ntanaman Hari Ini...",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight(700)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Ayo pilih tanaman pertama kamu\ndan mulai tanam sekarang!",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF757575)
                                    )

                                }

                                Image(
                                    painter = painterResource(id = R.drawable.pohon2),
                                    contentDescription = "Icon Tanaman",
                                    modifier = Modifier
                                        .fillMaxHeight(),
                                    alignment = Alignment.BottomEnd,
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }

                }
            }



            // --- BAGIAN SEARCH ---
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .height(48.dp)
                        .background(Color(0xFFF4F5F7), shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 14.dp, vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterStart),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.searchicon), // Pastikan icon ada
                            contentDescription = "Search icon",
                            tint = Color(0xFF98A0AA)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Cari tanaman...",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF98A0AA)
                        )
                    }
                }
            }
            //rekomendasi untukmu
            item {
                Spacer(modifier = Modifier.height(17.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween // Biar text ke kiri dan kanan mentok
                ) {
                    Text(
                        text = "Rekomendasi Untukmu",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700)
                    )
                    Text(
                        text = "Lihat Semua",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF179778)
                    )
                }
            }

            item{
                LazyHorizontalGrid(rows = GridCells.Fixed(2),
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp))
                {
                    items(6){ index->
                        RekomendasiCard(index)
                    }
                }
            }
        }
    }
}

@Composable
fun RekomendasiCard(Index: Int) {
    val tanamanPict =listOf(R.drawable.rekom1, R.drawable.rekom2, R.drawable.rekom3, R.drawable.rekom4, R.drawable.rekom5, R.drawable.rekom6)
    val warna = listOf(Color(0xFF179778),Color(0xFF179778),Color(0xFF179778),Color(0xFFE56C3F),Color(0xFFE56C3F),Color(0xFFC10101))
    val tingkatan = listOf("Mudah","Mudah","Mudah","Sedang","Sedang","Sulit")

    Box(
        modifier = Modifier
            .width(158.dp)
            .height(191.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .align(Alignment.Center)
        ){
            Image(
                painter = painterResource(id = tanamanPict[Index]),
                contentDescription = "Tanaman",
                modifier = Modifier
                    .fillMaxWidth()
            )

        }
    }

}
@Preview(showBackground = true)
@Composable
fun HomepagePreview() {
    Homepage(navController = rememberNavController(), username = "Nasywa")
}