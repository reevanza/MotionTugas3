package com.example.hydropome.ui.screens.pantautanaman

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.foundation.background
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
//import  androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hydropome.ui.button.BackButton
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantauTanamanTask(navController: NavHostController) {
    Scaffold(

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
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
                        .clip(BottomArcShape()),
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
            ) {
                Text(
                    text = "Selada Hidroponik",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                ) {
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
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(R.drawable.pohon_hijau),
                        contentDescription = "",
                        tint = Color(0xFF179778),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Hari ke-1",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
//                        color = Color(0xFF98A0AA)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                val myShape = RoundedCornerShape(16.dp)
                Box(
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                        .width(335.dp)
                        .height(112.dp)
                        .shadow(elevation = 8.dp, shape = myShape)
                        .background(Color.White, shape = myShape)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
//                        verticalAlignment = Alignment.CenterVertically
                    
                    ){

                        Image(
                            painter = painterResource(R.drawable.pohon),
                            contentDescription = "",
                            modifier = Modifier.size(300.dp)
                                .align(Alignment.BottomEnd),
                        )
                        Text(
                            text = "Progress menanam",

                        )
                        Spacer(modifier = Modifier.width(8.dp))

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PantauTanamanTaskPreview() {
    PantauTanamanTask(navController = rememberNavController())
}