package com.example.exampleshop.models

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
    val destination: Int,
    val icon: Painter,
    val showBadge: Boolean = false,
    val badgeValue: Int? = null,
)
