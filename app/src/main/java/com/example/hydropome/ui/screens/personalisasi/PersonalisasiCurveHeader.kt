package com.example.hydropome.ui.screens.personalisasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.draw.clip

@Composable
fun PersonalisasiCurveHeader() {
    val curveShape = GenericShape { size, _ ->
        val w = size.width
        val h = size.height

        moveTo(0f, 0f)
        lineTo(0f, h * 0.55f)

        quadraticBezierTo(
            w * 0.5f,
            h * 0.8f,
            w,
            h * 0.55f
        )

        lineTo(w, 0f)
        close()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp)
            .clip(curveShape)
            .background(Color(0xFF004B40))
    )
}