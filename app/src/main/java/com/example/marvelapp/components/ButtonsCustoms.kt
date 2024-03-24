package com.example.marvelapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ButtonOutline(onClick:() -> Unit, text: String,
                  verticalPadding: Dp = 5.dp,
                  horizontalPadding: Dp = 20.dp
) {
    OutlinedButton(onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = verticalPadding, horizontal = horizontalPadding),
    ) {
        Text(text, color = MaterialTheme.colorScheme.outline)
    }
}