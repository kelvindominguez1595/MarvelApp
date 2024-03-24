package com.example.marvelapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.core.graphics.toColorInt
import com.example.marvelapp.utils.Constants.Companion.BG_MARVEL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopTapBarCustom(
    title: String,
    showBackButton: Boolean = false,
    showBSearch: Boolean = false,
    showSignOut: Boolean = false,
    onClickBackButton: () -> Unit,
    onClickSearch: () -> Unit,
    onClickSignOut: () -> Unit
) {
    TopAppBar(
        title = {
            LabelCustom(text = title, color = Color.White, fontWeight = FontWeight.Bold)
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(BG_MARVEL.toColorInt())
        ),

        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { onClickBackButton() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = Color.White)
                }
            }
        },
        actions = {
            if(showBSearch){
                IconButton(onClick = { onClickSearch() }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "", tint = Color.White)
                }
            }
            if(showSignOut){
                IconButton(onClick = { onClickSignOut() }) {
                    Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Sign Out", tint = Color.White)
                }

            }

        }
    )
}