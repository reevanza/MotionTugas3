package com.example.hydropome.ui.screens.pantautanaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydropome.R
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun PopupSelesai(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .background(color = Color.White)
            .height(329.dp)
            .width(345.dp)
            .clip(RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center
    ){
        Column(){
            Image(
                painter = painterResource(R.drawable.successmark),
                contentDescription = "success",
                modifier = Modifier
                    .size(100.dp),
//                    .offset(y = 7.dp), //nurunin gambar 7.dp
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Tugas Hari ke-1 Selesai  \uD83C\uDF89",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(28.dp))
            Box(modifier = Modifier
                .background(color = Color(0xFF179778))
                .clip(RoundedCornerShape(12.dp))
            ){
                Text(
                    text = "Hari Berikutnya",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .background(color = Color(0xFFE8F5F2))
                .clip(RoundedCornerShape(12.dp))
                .out
            ){
                Text(
                    text = "Hari Berikutnya",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}