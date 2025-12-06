package com.example.hydropome.ui.screens.pantautanaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.hydropome.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.ui.dataclass.Tanamanmu
import com.example.hydropome.ui.dataclass.getcolor
import com.example.hydropome.ui.screens.shape.BottomArcShape
import kotlin.collections.listOf

@Composable
fun PantauTanamanList(navController: NavController,innerPadding: PaddingValues = PaddingValues()){
    //  -- DATA DUMMY --
    val listTanaman = listOf(
        Tanamanmu("Selada Hidroponik", "Mudah", 1, R.drawable.rekom1),
        Tanamanmu("Bayam Hidroponik", "Mudah", 5, R.drawable.bayam),
        Tanamanmu("Cabai Hidroponik", "Sulit", 10,R.drawable.cabai)
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
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 28.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, start = 24.dp, end = 24.dp)
                                .height(165.dp),
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                                    .padding(top = 28.dp)
                            ) {
                                Text(
                                    text = "Bagaimana Kabar",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Tanamanmu Hari Ini?",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.pohon),
                                contentDescription = "Icon Tanaman",
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .offset(y = 7.dp), //nurunin gambar 7.dp
                                alignment = Alignment.BottomEnd,
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    //-- SEARCH BOX --
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 20.dp) // Margin kiri-kanan dari layar
                            .shadow(elevation = 7.dp, shape = RoundedCornerShape(12.dp))
                            .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(12.dp))
                            .height(50.dp)
                            .align(Alignment.BottomCenter), // Posisi di Header
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
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .shadow(elevation = 15.dp,spotColor = Color.Gray.copy(alpha = 0.5f), // Ubah jadi abu-abu transparan (20%)
                            ambientColor = Color.Gray.copy(alpha = 0.2f))
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFFFFFFF))
                        .padding(12.dp)

                ) {
                    Text(
                        text = "Daftar Tanamanmu",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    filteredList.forEachIndexed { index, item ->
                        val statusColor = getcolor(item.status)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(onClick = { navController.navigate("PantauTanamanTask") })
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(item.image),
                                contentDescription = "Tanaman",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .size(72.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp),

                            ) {
                                Text(
                                    text = item.namaTanaman,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(600)
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.bulethijau),
                                        contentDescription = "status",
                                        tint = statusColor,
                                        modifier = Modifier.size(10.dp)
                                    )
                                    Text(
                                        text = item.status,
                                        color = statusColor,
                                        fontWeight = FontWeight(400),
                                        fontSize = 12.sp
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.plant_kecil),
                                        contentDescription = "hari",
                                        tint = Color(0xFF179778),
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Text(text = "Hari ke -${item.hariKe}",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(400)
                                        )
                                }


                            }
                            Spacer(modifier = Modifier.width(60.dp))
                            Box(
                                modifier = Modifier
                                    .height(36.dp)
                                    .width(64.dp)
                                    .background(color = Color(0xFF179778), shape = RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ){
                                Text(text = "Pantau",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(600))
                            }
                        }
                        if (index != filteredList.lastIndex) {
                            Divider(
                                color = Color(0xFFEDEDED),
                                thickness = 1.dp,
                                modifier = Modifier
                                    .padding(vertical = 12.dp)
                            )
                        }


                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .shadow(elevation = 15.dp,spotColor = Color.Gray.copy(alpha = 0.5f), // Ubah jadi abu-abu transparan (20%)
                            ambientColor = Color.Gray.copy(alpha = 0.2f))
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFFFFFFF))
                        .padding(12.dp)

                ) {
                    Text(
                        text = "Riwayat",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    listTanaman.forEachIndexed { index, item ->
                        val statusColor = getcolor(item.status)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(item.image),
                                contentDescription = "Tanaman",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .size(72.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp),

                                ) {
                                Text(
                                    text = item.namaTanaman,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(600)
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.bulethijau),
                                        contentDescription = "status",
                                        tint = statusColor,
                                        modifier = Modifier.size(10.dp)
                                    )
                                    Text(
                                        text = item.status,
                                        color = statusColor,
                                        fontWeight = FontWeight(400),
                                        fontSize = 12.sp
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.plant_kecil),
                                        contentDescription = "hari",
                                        tint = Color(0xFF179778),
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Text(text = "Hari ke -${item.hariKe}")
                                }
                            }
                        }
                        if (index != listTanaman.lastIndex) {
                            Divider(
                                color = Color(0xFFEDEDED),
                                thickness = 1.dp,
                                modifier = Modifier
                                    .padding(vertical = 12.dp)
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
fun PantauTanamanList() {
    PantauTanamanList(navController = rememberNavController())
}