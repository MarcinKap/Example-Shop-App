package com.example.exampleshop.ui.mainActivity.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exampleshop.R
import com.example.exampleshop.models.BottomNavItem

@Composable
fun BottomNavCompose(
    openFragment: (Int) -> Unit,
    selectedId: Int
) {
    val selectedFragment = rememberSaveable { mutableStateOf(selectedId) }

    changeSelectedIcon(
        changeSelectedIcon = { selectedFragment.value = it },
        selectedId = selectedId
    )

    val bottomNavItemList = listOf(
        BottomNavItem(
            destination = R.id.homeFragment,
            icon = painterResource(id = R.drawable.baseline_home_black_24dp)
        ),
        BottomNavItem(
            destination = R.id.searchFragment,
            icon = painterResource(id = R.drawable.baseline_search_black_24dp)
        ),
        BottomNavItem(
            destination = R.id.shoppingCartFragment,
            icon = painterResource(id = R.drawable.baseline_shopping_cart_black_24dp)
        ),
        BottomNavItem(
            destination = R.id.favouritesFragment,
            icon = painterResource(id = R.drawable.baseline_star_black_24dp)
        ),
        BottomNavItem(
            destination = R.id.userSettingsFragment,
            icon = painterResource(id = R.drawable.baseline_person_black_24dp)
        ),
    )




    Surface(elevation = 4.dp) {
        Column {
            Divider(color = colorResource(id = R.color.icon_color))
            BottomNavigation(
                modifier = Modifier.weight(1f),
                backgroundColor = Color.White
            ) {
                bottomNavItemList.forEach {
                    val isSelected = selectedFragment.value == it.destination
                    BottomNavigationItem(
                        selected = isSelected,
                        onClick = { openFragment(it.destination) },
                        icon = {
                            Icon(
                                painter = it.icon,
                                contentDescription = null,
                                tint = if (isSelected) colorResource(id = R.color.primary) else colorResource(
                                    id = R.color.icon_color
                                )
                            )
                        }
                    )
                }
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavComposePreview() {
    MaterialTheme {
        BottomNavCompose(openFragment = {}, selectedId = 0)
    }
}


fun changeSelectedIcon(
    changeSelectedIcon: (Int) -> Unit,
    selectedId: Int
) {
    when (selectedId) {
        R.id.homeFragment, R.id.searchFragment, R.id.shoppingCartFragment, R.id.favouritesFragment, R.id.userSettingsFragment -> changeSelectedIcon(
            selectedId
        )
    }
}