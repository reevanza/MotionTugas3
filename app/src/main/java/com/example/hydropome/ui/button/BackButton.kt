package com.example.hydropome.ui.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydropome.R

@Composable
@Preview
fun BackButton(){
    val myShape = RoundedCornerShape(12.dp)
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(width =1.dp, color= Color(0xFFE8ECF4), shape = myShape),
        contentAlignment = Alignment.Center


    ){
        Icon(
            painter = painterResource(R.drawable.arrow_left),
            contentDescription = "tombol kembali"
        )
    }
}