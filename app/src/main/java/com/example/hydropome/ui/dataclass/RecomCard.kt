package com.example.hydropome.ui.dataclass

import androidx.compose.ui.graphics.Color

data class RecomCard(
    val image: Int,
    val status: String,
    val namaTanaman : String,
    val durasi : String
)
fun getStatusColor(status: String): Color {
    return when (status) {
        "Mudah" -> Color(0xFF179778) // Hijau
        "Sedang" -> Color(0xFFE56C3F) // Orange
        "Sulit" -> Color(0xFFC10101)  // Merah
        else -> Color.Gray
    }
}