package com.example.hydropome.ui.screens.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // Import all layout
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.hydropome.ui.dataclass.RecomCard
import com.example.hydropome.ui.dataclass.getStatusColor
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
            //header hijau kurva
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
            val listTanaman = listOf(
                RecomCard(R.drawable.rekom1, "Mudah", "Selada Hidroponik", "3-5 Ming"),
                RecomCard(R.drawable.rekom2, "Mudah", "Bayam Hidroponik", "3-4 Ming"),
                RecomCard(R.drawable.rekom3, "Mudah", "Pakcoy Hidroponik", "4-5 Ming"),
                RecomCard(R.drawable.rekom4, "Sedang", "Tomat Cherry", "8-10 Ming"),
                RecomCard(R.drawable.rekom5, "Sedang", "Seledri Hidroponik", "5-6 Ming"),
                RecomCard(R.drawable.rekom6, "Sulit", " Stroberi Hidroponik", "12-16 Ming")
            )


            item{
                Column(
                    modifier = Modifier
                        .fillMaxSize() // Pastikan container ini punya tinggi
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp) // Jarak antar baris ke bawah
                ) {
                    // 1. Pecah data menjadi paket isi 2 (Kiri & Kanan)
                    listTanaman.chunked(2).forEach { rowItems ->

                        // 2. Buat Row untuk menampung 2 item ke samping
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(20.dp) // Jarak kiri-kanan
                        ) {
                            // 3. Loop item di dalam baris ini
                            for (item in rowItems) {
                                val bannerColor = getStatusColor(item.status)

                                // Box Card
                                Box(
                                    modifier = Modifier
                                        .weight(1f) // PENTING: Pakai weight(1f) agar lebar dibagi 2 rata
                                        .fillMaxHeight()
                                        .width(157.dp)// Tinggi dinaikkan dikit biar muat (170 -> 180)
                                        // Perbaikan urutan: Shadow dulu, baru Background
                                        .padding(8.dp)
                                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp), ambientColor = Color.Black.copy(alpha = 0.1f))
                                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                                        .clickable(onClick = { navController.navigate("LamanTanaman") })

                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(8.dp)
                                        // align center dihapus karena default column sudah top-start (lebih rapi)
                                    ) {
                                        Image(
                                            painter = painterResource(id = item.image),
                                            contentDescription = "Tanaman",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(10.dp))
                                                .height(115.dp) // Kecilin dikit (128 -> 115) biar teks muat
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = item.namaTanaman,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight(700),
                                            maxLines = 1 // Biar ga turun baris
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        // Spacer weight agar Row status selalu di dasar kartu
                                        Spacer(modifier = Modifier.weight(1f))

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(
                                                painter = painterResource(R.drawable.bulethijau),
                                                contentDescription = "status",
                                                tint = bannerColor,
                                                modifier = Modifier.size(8.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = item.status,
                                                color = bannerColor,
                                                fontWeight = FontWeight(400),
                                                fontSize = 11.sp
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Icon(
                                                painter = painterResource(R.drawable.clock),
                                                contentDescription = "durasi",
                                                tint = Color(0xFF98A0AA),
                                                modifier = Modifier.size(12.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = item.durasi,
                                                color = Color(0xFF98A0AA),
                                                fontWeight = FontWeight(400),
                                                fontSize = 11.sp
                                            )
                                        }
                                    }
                                }
                            }

                            // 4. Penyeimbang jika jumlah data ganjil (Cuma 1 di baris terakhir)
                            if (rowItems.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

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
                        text = "Starter  Kit Flash Sale \uD83D\uDD25",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Box(
                            modifier = Modifier
                                .size(22.dp)
                                .background(Color(0xFF179778), RoundedCornerShape(6.dp)),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "01",
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = ":",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF179778)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Box(
                            modifier = Modifier
                                .size(22.dp)
                                .background(Color(0xFF179778), RoundedCornerShape(6.dp)),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "20",
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = ":",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF179778)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Box(
                            modifier = Modifier
                                .size(22.dp)
                                .background(Color(0xFF179778), RoundedCornerShape(6.dp)),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "47",
                                fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomepagePreview() {
    Homepage(navController = rememberNavController(), username = "Nasywa")
}