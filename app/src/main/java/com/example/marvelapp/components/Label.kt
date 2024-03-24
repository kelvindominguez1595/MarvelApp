package com.example.marvelapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LabelCustom(text: String,
                fontSize: FontSize = FontSize.Title,
                fontWeight: FontWeight = FontWeight.Normal,
                fontStyle: FontStyle = FontStyle.Normal,
                color: Color = Color.Black,
                verticalPadding: Dp = 5.dp,
                horizontalPadding: Dp = 20.dp,
                isOnClick: Boolean = false,
                onClick: () -> Unit = {}
) {
    val fntSize = when(fontSize){
        FontSize.H1 -> 96.sp
        FontSize.H2 -> 60.sp
        FontSize.H3 -> 48.sp
        FontSize.H4 -> 34.sp
        FontSize.H5 -> 24.sp
        FontSize.H6 -> 20.sp
        FontSize.Title -> 16.sp
        FontSize.Body -> 14.sp
        FontSize.Caption -> 12.sp
        FontSize.Overline -> 10.sp
    }
    Text(
        text = text,
        fontSize = fntSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        color = color,
        modifier =
        if(isOnClick)
            Modifier.clickable(onClick = onClick)
                .padding(
                    vertical = verticalPadding,
                    horizontal = horizontalPadding
                )
        else
            Modifier.padding(
                vertical = verticalPadding,
                horizontal = horizontalPadding
            )
    )
}

enum class FontSize { H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    Title,
    Body,
    Caption,
    Overline
}