package com.example.exampleshop.ui.mainActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.exampleshop.R
import com.example.exampleshop.databinding.ActivityMainBinding
import com.example.exampleshop.ui.mainActivity.compose.BottomNavCompose
import com.example.exampleshop.util.CustomNavigationOptions

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val controller =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController



        controller.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.bottomNav.setContent {
                BottomNavCompose(
                    openFragment = {
                        if (controller.currentDestination?.id != it) {
                            controller.navigate(
                                it,
                                null,
                                navOptions = bottomMenuNavOptions(it, destination.id)
                            )
                        }
                    },
                    selectedId = destination.id
                )
            }
        }


    }


    private fun bottomMenuNavOptions(
        selectedViewId: Int,
        currentViewId: Int,
    ): NavOptions {
        val selectedViewNumber = getNumberByViewId(selectedViewId)
        val currentViewNumber = getNumberByViewId(currentViewId)
        return getNavigationsOptionsByViewId(selectedViewNumber, currentViewNumber)
    }

    fun getNumberByViewId(viewId: Int): Int {
        when (viewId) {
            R.id.homeFragment -> return 1
            R.id.searchFragment -> return 2
            R.id.shoppingCartFragment -> return 3
            R.id.favouritesFragment -> return 4
            R.id.userSettingsFragment -> return 5
            else -> return 0
        }
    }

    fun getNavigationsOptionsByViewId(selectedViewNumber: Int, currentViewNumber: Int): NavOptions {
        if (selectedViewNumber < currentViewNumber) {
            return CustomNavigationOptions.HorizontalAnimationsBackwardsRoot.navOptions
        } else {
            return CustomNavigationOptions.HorizontalAnimationsForwardRoot.navOptions
        }
    }

}