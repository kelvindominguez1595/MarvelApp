package com.example.marvelapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.marvelapp.R
import com.example.marvelapp.utils.Constants
import com.example.marvelapp.utils.Constants.Companion.BG_MARVEL
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController) {

    LaunchedEffect(key1 = true){
        delay(2000)
        if(!FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate("Home")
        }else {
            navController.navigate("Login")
        }
    }
    Box(Modifier.fillMaxSize().background(Color(BG_MARVEL.toColorInt())), contentAlignment = Alignment.Center){
        Image(painter = painterResource(id = R.drawable.marvel_logo), contentDescription = "Logo de Marvel")
    }
}