package com.example.marvelapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OutlineInputCustom(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    color: Color = MaterialTheme.colorScheme.outline,
    keyBoarType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    verticalPadding: Dp = 5.dp,
    horizontalPadding: Dp = 20.dp
) {
    OutlinedTextField(
        label = { Text(text = label, color = color) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = color
        ),
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = verticalPadding, horizontal = horizontalPadding),
        textStyle = TextStyle(color = color),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyBoarType),
        visualTransformation = if(isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}