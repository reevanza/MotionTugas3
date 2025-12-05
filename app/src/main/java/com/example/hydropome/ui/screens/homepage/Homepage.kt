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
import com.example.hydropome.ui.dataclass.StarterKit
import com.example.hydropome.ui.dataclass.getStatusColor
import com.example.hydropome.ui.screens.shape.BottomArcShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration


@Composable
fun Homepage(
    navController: NavController,
    username: String,
    innerPadding: PaddingValues = PaddingValues()
) {
    //-- DATA DUMMY UNTUK CARD REKOMENDASI --
    val listTanaman = listOf(
        RecomCard(R.drawable.rekom1, "Mudah", "Selada Hidroponik", "3-5 Ming"),
        RecomCard(R.drawable.rekom2, "Mudah", "Bayam Hidroponik", "3-4 Ming"),
        RecomCard(R.drawable.rekom3, "Mudah", "Pakcoy Hidroponik", "4-5 Ming"),
        RecomCard(R.drawable.rekom4, "Sedang", "Tomat Cherry", "8-10 Ming"),
        RecomCard(R.drawable.rekom5, "Sedang", "Seledri Hidroponik", "5-6 Ming"),
        RecomCard(R.drawable.rekom6, "Sulit", " Stroberi Hidroponik", "12-16 Ming")
    )
    var searchQuery by remember { mutableStateOf("") }
    val filteredList = listTanaman.filter { item ->
        item.namaTanaman.contains(searchQuery, ignoreCase = true)
    }
    Scaffold(
        modifier = Modifier.padding(innerPadding)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            //-- HEADER--
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
                            // AVATAR
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
                        // -- PROGRESS BOX --
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



            // ---  SEARCH BAR ---
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp) // Margin kiri-kanan dari layar
                        .shadow(elevation = 7.dp, shape = RoundedCornerShape(12.dp))
                        .background(Color(0xFFF4F5F7), shape = RoundedCornerShape(12.dp))
                        .height(50.dp),
//                        .align(Alignment.BottomCenter), // Posisi di Header
                    contentAlignment = Alignment.CenterStart
                ) {
                    TextField(
                        value = searchQuery,
                        onValueChange = {newText -> searchQuery = newText},
                        placeholder = {
                            Text(
                                text = "Cari Tanaman",
                                fontSize = 14.sp,
                                color = Color(0xFF98A0AA)
                            )
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.searchicon), // Pastikan icon ada
                                contentDescription = "Search icon",
                                tint = Color(0xFF98A0AA)
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.colors( // Hilangkan warna bawaan TextField
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent, // Hilangkan garis bawah
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            //-- REKOMENDASI UNTUKMU & LIHAT SEMUA--
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



            //-- CARD TANAMAN REKOMENDASI --
            item{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp) // Jarak antar baris ke bawah
                ) {
                    //  isi 2 (Kiri & Kanan)
                    filteredList.chunked(2).forEach { rowItems ->

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(20.dp) // Jarak kiri-kanan
                        ) {

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

                                    ) {
                                        Image(
                                            painter = painterResource(id = item.image),
                                            contentDescription = "Tanaman",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(10.dp))
                                                .height(115.dp)
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

                            // Penyeimbang jika jumlah data ganjil (Cuma 1 di baris terakhir)
                            if (rowItems.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }

            // -- FLASHSALE & COUNTDOWN --
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
            val listStarterKitSale = listOf(
                StarterKit("Paket Pipa NFT","Rp 150.000", "Rp 125.000", R.drawable.paketpipanft),
                StarterKit("Paket Lengkap","Rp 75.000", "Rp 55.000", R.drawable.paketlengkap),
                StarterKit("Paket Pipa NFT","Rp 150.000", "Rp 125.000", R.drawable.paketpipanft),
                StarterKit("Paket Lengkap","Rp 75.000", "Rp 55.000", R.drawable.paketlengkap)

            )

            item{
                Column(
                    modifier = Modifier
                        .fillMaxSize() // Pastikan container ini punya tinggi
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp) // Jarak antar baris ke bawah
                ) {
                    // 1. Pecah data menjadi paket isi 2 (Kiri & Kanan)
                    listStarterKitSale.chunked(2).forEach { rowItems ->

                        // 2. Buat Row untuk menampung 2 item ke samping
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(20.dp) // Jarak kiri-kanan
                        ) {
                            // 3. Loop item di dalam baris ini
                            for (item in rowItems) {


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

                                    ) {
                                        Image(
                                            painter = painterResource(id = item.image),
                                            contentDescription = "gambar starter kit",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(10.dp))
                                                .height(115.dp)
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = "Starter Kit",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF757575),
                                            maxLines = 1 // Biar ga turun baris
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = item.namaStraterKit,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight(700),
                                            maxLines = 1 // Biar ga turun baris
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        // Spacer weight agar Row status selalu di dasar kartu
                                        Spacer(modifier = Modifier.weight(1f))

                                        Row(verticalAlignment = Alignment.CenterVertically) {

                                            Text(
                                                text = item.hargaDiskon,
                                                color = Color(0xFF179778),
                                                fontWeight = FontWeight(700),
                                                fontSize = 14.sp
                                            )

                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = item.hargaAwal,
                                                color = Color(0xFF757575),
                                                fontWeight = FontWeight(400),
                                                fontSize = 11.sp,
                                                style = TextStyle(textDecoration = TextDecoration.LineThrough)
                                            )
                                        }
                                    }
                                }
                            }

                            // Penyeimbang jika jumlah data ganjil (Cuma 1 di baris terakhir)
                            if (rowItems.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
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