package com.example.marvelapp.components

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AlertCustom(
    title: String,
    message: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    val scroll = rememberScrollState(0)
    AlertDialog(
        title = { Text(title) },
        text = { Text(
            text = message,
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(scroll)
        )
        },
        onDismissRequest = {onDismissClick() },
        confirmButton = {
            ButtonOutline(onClick = { onConfirmClick() }, text = confirmText)
        })
}