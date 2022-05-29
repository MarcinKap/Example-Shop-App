package com.example.exampleshop.ui.mainActivity.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exampleshop.R

@Composable
fun BottomNavCompose(
    openFragment: (Int) -> Unit,
    selectedId: Int
) {
    val selectedIcon = rememberSaveable { mutableStateOf(selectedId) }

    changeSelectedIcon(
        changeSelectedIcon = { selectedIcon.value = it },
        selectedId = selectedId
    )

    Surface(elevation = 4.dp) {
        Column {
            Divider(color = colorResource(id = R.color.icon_color))
            Row(
                modifier = Modifier.height(56.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIconButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.baseline_home_black_24dp),
                    selected = selectedIcon.value == R.id.homeFragment,
                    onClick = { openFragment(R.id.homeFragment) }
                )
                CustomIconButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.baseline_search_black_24dp),
                    selected = selectedIcon.value == R.id.searchFragment,
                    onClick = { openFragment(R.id.searchFragment) }
                )
                CustomIconButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.baseline_shopping_cart_black_24dp),
                    selected = selectedIcon.value == R.id.shoppingCartFragment,
                    onClick = { openFragment(R.id.shoppingCartFragment) }
                )
                CustomIconButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.baseline_star_black_24dp),
                    selected = selectedIcon.value == R.id.favouritesFragment,
                    onClick = { openFragment(R.id.favouritesFragment) }
                )
                CustomIconButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                    painter = painterResource(id = R.drawable.baseline_person_black_24dp),
                    selected = selectedIcon.value == R.id.userSettingsFragment,
                    onClick = { openFragment(R.id.userSettingsFragment) }
                )
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


@Composable
fun CustomIconButton(
    modifier: Modifier = Modifier,
    painter: Painter,
    selected: Boolean,
    onClick: () -> Unit
) {
    val color =
        if (selected) colorResource(id = R.color.primary) else colorResource(id = R.color.icon_color)

    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = color
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomIconButtonPreview() {
    MaterialTheme {
        CustomIconButton(
            painter = painterResource(id = R.drawable.baseline_home_black_24dp),
            selected = false,
            onClick = {}
        )
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