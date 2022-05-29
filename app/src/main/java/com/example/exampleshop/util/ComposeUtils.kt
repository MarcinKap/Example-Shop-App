package com.example.exampleshop.util

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.exampleshop.R

@Composable
fun DialogFunctionNotIntroduced(
    onDismissRequest: ()->Unit
){

    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = {
                Text(
                    text = "Alert Dialog",
                    style = MaterialTheme.typography.h6.copy(color = Color.Black.copy(0.87f))
                )
        },
        text = {
               Text(
                   text = "This function is not yet implemented.",
                   style = MaterialTheme.typography.body1.copy(color = Color.Black.copy(0.6f))
               )
        },
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text(
                    text = "OK",
                    style = MaterialTheme.typography.button
                )
            }
        }
    )
}

@Composable
fun HorizontalDivider(){
    Divider(color = colorResource(id = R.color.icon_color))
}