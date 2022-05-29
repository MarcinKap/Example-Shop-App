package com.example.exampleshop.util

import androidx.navigation.NavOptions
import com.example.exampleshop.R

sealed class CustomNavigationOptions(val navOptions: NavOptions) {

    object HorizontalAnimationsForwardRoot : CustomNavigationOptions(
        NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left_main)
            .setPopEnterAnim(R.anim.slide_in_left_main)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()
    )

    object HorizontalAnimationsForward : CustomNavigationOptions(
        NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()
    )

    object HorizontalAnimationsBackwardsRoot : CustomNavigationOptions(
        NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(R.anim.slide_in_left_main)
            .setExitAnim(R.anim.slide_out_right)
            .setPopEnterAnim(R.anim.slide_in_right)
            .setPopExitAnim(R.anim.slide_out_left_main)
            .build()
    )

    object HorizontalAnimationsBackwards : CustomNavigationOptions(
        NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_left)
            .setExitAnim(R.anim.slide_out_right)
            .setPopEnterAnim(R.anim.slide_in_right)
            .setPopExitAnim(R.anim.slide_out_left)
            .build()
    )

    object VerticalAnimationsBackwardsWithoutPopEnter : CustomNavigationOptions(
        NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_bottom)
            .setExitAnim(R.anim.slide_out_top)
            .setPopExitAnim(R.anim.slide_out_bottom)
            .build()
    )

    object VerticalAnimationsBackwards : CustomNavigationOptions(
        NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_bottom)
            .setExitAnim(R.anim.slide_out_top)
            .setPopEnterAnim(R.anim.slide_in_top)
            .setPopExitAnim(R.anim.slide_out_bottom)
            .build()
    )
}
