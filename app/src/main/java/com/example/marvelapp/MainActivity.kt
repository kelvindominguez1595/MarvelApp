package com.example.marvelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.marvelapp.navigation.NavNavigation
import com.example.marvelapp.ui.theme.MarvelAppTheme
import com.example.marvelapp.viewModels.CharactersViewModel
import com.example.marvelapp.viewModels.LoginViewModel
import com.example.marvelapp.viewModels.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginVM: LoginViewModel by viewModels()
        val registerVM: RegisterViewModel by viewModels()
        val charactersVM: CharactersViewModel by viewModels()

        setContent {
            MarvelAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavNavigation(loginVM, registerVM, charactersVM)
                }
            }
        }
    }
}

