package com.example.exampleshop.ui.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.OriginalSize
import coil.size.Size
import com.example.exampleshop.R
import com.example.exampleshop.models.Category
import com.example.exampleshop.util.DialogFunctionNotIntroduced
import com.example.exampleshop.util.HorizontalDivider

@Composable
fun HomeFragmentComposeView() {

    val listState = rememberLazyListState()

    val showDivider by remember {
        derivedStateOf {
            listState.firstVisibleItemScrollOffset > 0
        }
    }

    var turnOnAlertDialog by remember { mutableStateOf(false) }

    Surface() {
        Column {
            HomeFragmentTop(notificationsActive = false)
            if (showDivider) {
                HorizontalDivider()
            } else {
                Spacer(modifier = Modifier.height(1.dp))
            }
            Box(Modifier.weight(1f)) {

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    state = listState
                ) {
                    item {
                        Spacer(modifier = Modifier.height(64.dp))
                    }
                    item {
                        CategoryLazyRow(
                            categoryList = Category.getDefaultList(),
                            openCategory = {turnOnAlertDialog = true}
                        )
                    }
                    item {
                        AdvertismentBlock(
                            title = "Guess - Sunglasses",
                            category = "Sunglasses",
                            imageUrl = "https://img.dummyapi.io/photo-1510414696678-2415ad8474aa.jpg",
                            description = "Additional informations",
                            openAdvertisment = {turnOnAlertDialog = true}
                        )
                    }

                    item {
                        Box(
                            modifier = Modifier
                                .height(700.dp)
                                .width(200.dp)
                                .background(Color.DarkGray)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .height(64.dp)
                        .align(Alignment.TopCenter),
                    contentAlignment = Alignment.Center
                ) {
                    SearchingField(
                        search = {}
                    )
                }
            }
        }
    }

    if (turnOnAlertDialog) {
        DialogFunctionNotIntroduced {
            turnOnAlertDialog = false
        }
    }

}


@Composable
fun HomeFragmentTop(
    modifier: Modifier = Modifier,
    notificationsActive: Boolean,
) {
    val notificationsIcon =
        painterResource(id = if (notificationsActive) R.drawable.baseline_notifications_active_black_24dp else R.drawable.baseline_notifications_black_24dp)

    var turnOnAlertDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .height(56.dp)
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Hello",
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.width(24.dp))
        IconButton(onClick = { turnOnAlertDialog = true }) {
            Icon(
                painter = notificationsIcon,
                contentDescription = null
            )
        }
    }

    if (turnOnAlertDialog) {
        DialogFunctionNotIntroduced {
            turnOnAlertDialog = false
        }
    }
}

@Composable
fun SearchingField(search: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
        value = searchText,
        onValueChange = { searchText = it },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Send,
        ),
        keyboardActions = KeyboardActions(
            onSend = { search(searchText) }
        )
    )

}

@Composable
fun CategoryLazyRow(
    categoryList: List<Category>,
    openCategory: (Long) -> Unit
) {

    LazyRow() {
        items(
            items = categoryList,
            key = { "Category ${it.id}" }
        ) {
            Column(
                modifier = Modifier
                    .clickable { openCategory(it.id) }
                    .size(80.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = it.categoryIcon),
                    contentDescription = null
                )
                Text(
                    text = it.categoryName,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Composable
fun AdvertismentBlock(
    title: String,
    category: String,
    imageUrl: String,
    description: String,
    openAdvertisment: ()->Unit,
){
    Box(modifier = Modifier.background(Color.Gray).clickable { openAdvertisment() }) {
        Column(
            Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            size(Size.ORIGINAL)
                        }).build()
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Column(modifier = Modifier.background(Color.White).padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth()) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.W500)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = category,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.caption
                )
            }

        }
    }
}


