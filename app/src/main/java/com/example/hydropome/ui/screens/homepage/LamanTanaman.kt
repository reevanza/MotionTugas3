package com.example.hydropome.ui.screens.homepage

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding // <-- PASTIKAN IMPORT INI ADA
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import com.example.hydropome.ui.screens.shape.BottomArcShape
import  androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.hydropome.ui.button.BackButton
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.fillMaxSize
import com.example.hydropome.ui.button.MulaiTanamButton

//added laman tanaman
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LamanTanaman(navController: NavHostController){
    Scaffold(

    ) { innerPadding ->
        Column(
            modifier =Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(300.dp),

                ) {
                Image(
                    painter = painterResource(R.drawable.sayur),
                    contentDescription = "foto sayur",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(BottomArcShape())
                        .clickable(onClick = { navController.popBackStack() }),
                    contentScale = ContentScale.Crop
                )
                BackButton(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .statusBarsPadding()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ){
                Text(
                    text= "Selada Hidroponik",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal=25.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal =25.dp )
                ){
                    Icon(
                        painter = painterResource(R.drawable.bulethijau),
                        contentDescription = "",
                        tint = Color(0xFF179778),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Mudah",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF179778)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter= painterResource(R.drawable.clock),
                        contentDescription = "",
                        tint = Color(0xFF98A0AA),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "3-5 Ming",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF98A0AA)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text ="Deskripsi",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal=25.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Selada merupakan salah satu tanaman paling populer dalam budidaya hidroponik karena pertumbuhannya yang cepat dan perawatannya yang mudah. Tanaman ini cocok untuk pemula karena tidak memerlukan banyak nutrisi khusus atau perawatan intensif. Selada tumbuh subur di sistem hidroponik seperti NFT (Nutrient Film Technique) dan dapat dipanen dalam waktu 3–5 minggu setelah tanam",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .padding(horizontal=25.dp),
                    textAlign = TextAlign.Justify,
                    color = Color(0xFF757575)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Alat dan Bahan",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal = 25.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 12.sp
                            )
                        ) {
                            append("1. Wadah atau Bak Tanam ")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color = Color(0xFF757575)
                            )
                        ) {
                            append("– Tempat air nutrisi dan tanaman diletakkan.")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 12.sp
                            )
                        ){
                            append("2. Net Pot / Pot kecil berlubang")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color = Color(0xFF757575)
                            )
                        ){
                            append(" – Untuk menahan tanaman dan media tanam.")
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 12.sp
                            )
                        ){
                            append("3. Spons/Rockwool")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color= Color(0xFF757575)
                            )
                        ){
                            append(" – Media tanam tempat benih tumbuh.")
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 12.sp
                            )
                        ){
                            append("4. Spons/RockwoolPompa Air (untuk NFT)")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color= Color(0xFF757575)
                            )
                        ){
                            append(" – Mengalirkan nutrisi secara sirkulasi.")
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 12.sp
                            )
                        ){
                            append("5. Penutup atau Styrofoam (untuk rakit apung)")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color= Color(0xFF757575)
                            )
                        ){
                            append(" – Untuk menopang netpot.")
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    textAlign = TextAlign.Justify
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(700),
                                fontSize = 12.sp
                            )
                        ){
                            append("6. Alat ukur pH dan TDS")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                color= Color(0xFF757575)
                            )
                        ){
                            append(" – Untuk memantau kualitas larutan nutrisi.")
                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = "7. Benih Selada",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal = 25.dp)

                )
                Text(
                    text="8. Nutrisi AB Mix",
                    fontSize = 12.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal = 25.dp)

                )

                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text =" Tutorial Menanam",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                        .height(194.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(R.drawable.selada),
                        contentDescription = "selada",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Icon(
                        painter = painterResource(R.drawable.playbutton),
                        contentDescription = "play"
                    )

                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Menanam Selada Hidroponik",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal = 25.dp)

                    )
                Spacer(modifier = Modifier.height(57.dp))

                MulaiTanamButton(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable(onClick = { navController.navigate("Main?index=1")})
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LamanTanamanPreview() {
    LamanTanaman(navController = rememberNavController())
}