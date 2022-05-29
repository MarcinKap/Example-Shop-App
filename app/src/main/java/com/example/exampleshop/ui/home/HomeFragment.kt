package com.example.exampleshop.ui.home

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.exampleshop.ui.base.ComposeFragment


class HomeFragment : ComposeFragment() {

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        binding.mainComposeView.setContent {
            MaterialTheme() {
                Surface() {

                    Box(modifier = Modifier
                        .size(100.dp)
                        .background(Color.Green)){
                        Text(text = "Home Fragment")
                    }
                }
            }
        }
    }


}