package com.example.exampleshop.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.fragment.app.Fragment
import com.example.exampleshop.databinding.FragmentComposeBinding
import com.example.exampleshop.ui.base.ComposeFragment


class FavouritesFragment : ComposeFragment() {

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        binding.mainComposeView.setContent {
            MaterialTheme() {
                Text(text = "Favourites Fragment")
            }
        }
    }


}