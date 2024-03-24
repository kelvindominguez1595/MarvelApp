package com.example.marvelapp.views


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.marvelapp.viewModels.CharactersViewModel
import com.example.marvelapp.viewModels.LoginViewModel

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.marvelapp.components.CardCustom
import com.example.marvelapp.components.LabelCustom
import com.example.marvelapp.components.SpacerHeight
import com.example.marvelapp.components.TopTapBarCustom

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController, loginVM: LoginViewModel, charactersVM: CharactersViewModel) {
    Scaffold(
        topBar = {
            TopTapBarCustom(title = "Characters", false, true,true, {
                navController.navigate("Home")
            }, {
                navController.navigate("Search")
            },{
                loginVM.signOut()
                navController.navigate("Login")
            })
        },

        
    ){
        ContentHomeView(navController, charactersVM)
    }
}

@Composable
fun ContentHomeView(navController: NavController,charactersVM: CharactersViewModel) {
    val characters by charactersVM.characters.collectAsState()
    val pagesCharacters = charactersVM.charactersPage.collectAsLazyPagingItems()

    LazyVerticalGrid(
        modifier = Modifier.padding(top = 70.dp),
        columns = GridCells.Fixed(3)

    ){
        items(pagesCharacters.itemCount) {index ->
            val item = pagesCharacters[index]
            if (item != null) {
                CardCustom(data = item) {
                    navController.navigate("Detail/${item.id}")
                }
            }
        }
    }

}


