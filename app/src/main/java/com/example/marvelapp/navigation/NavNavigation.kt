package com.example.marvelapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.marvelapp.viewModels.CharactersViewModel
import com.example.marvelapp.viewModels.LoginViewModel
import com.example.marvelapp.viewModels.RegisterViewModel
import com.example.marvelapp.views.DetailView
import com.example.marvelapp.views.HomeView
import com.example.marvelapp.views.LoginView
import com.example.marvelapp.views.RegisterView
import com.example.marvelapp.views.SearchView
import com.example.marvelapp.views.SplashView

@Composable
fun NavNavigation(
    loginVM: LoginViewModel,
    registerVM: RegisterViewModel,
    charactersVM: CharactersViewModel
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "Splash"){
        composable("Splash"){
            SplashView(navController)
        }
        composable("Login"){
            LoginView(navController, loginVM)
        }
        composable("Register"){
            RegisterView(navController, registerVM, loginVM)
        }
        composable("Home"){
            HomeView(navController, loginVM, charactersVM)
        }
        composable("Search"){
            SearchView(navController, charactersVM)
        }
        composable("Detail/{id}",
            arguments = listOf( navArgument("id"){type = NavType.IntType})
        ){
            val id = it.arguments?.getInt("id") ?: 0
            DetailView(navController,charactersVM, id)
        }
    }
}