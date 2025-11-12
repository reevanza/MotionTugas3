package com.example.hydropome.ui.screens.Onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CurvedImage(imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
            .clip(
                GenericShape { size, _ ->
                    val width = size.width
                    val height = size.height
                    moveTo(0f, 0f)
                    lineTo(0f, height * 0.85f)
                    quadraticBezierTo(width / 2f, height * 1.1f, width, height * 0.85f)
                    lineTo(width, 0f)
                    close()
                }
            )
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
