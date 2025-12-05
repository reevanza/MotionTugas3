package com.example.hydropome.ui.dataclass

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Tanamanmu(
    val namaTanaman : String,
    val status : String,
    val hariKe : Int,
    @DrawableRes val image : Int
)
fun getcolor(status: String): Color {
    return when (status) {
        "Mudah" -> Color(0xFF179778) // Hijau
        "Sedang" -> Color(0xFFE56C3F) // Orange
        "Sulit" -> Color(0xFFC10101)  // Merah
        else -> Color.Gray
    }
}
