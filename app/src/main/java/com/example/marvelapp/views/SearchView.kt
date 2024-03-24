package com.example.marvelapp.views



import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.marvelapp.viewModels.CharactersViewModel
import com.example.marvelapp.viewModels.LoginViewModel

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marvelapp.components.ButtonOutline
import com.example.marvelapp.components.CardCustom
import com.example.marvelapp.components.OutlineInputCustom
import com.example.marvelapp.components.SpacerHeight
import com.example.marvelapp.components.TopTapBarCustom


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchView(navController: NavController, charactersVM: CharactersViewModel) {
    Scaffold(
        topBar = {
            TopTapBarCustom(title = "Search Characters", true, false,false, {
                navController.navigate("Home")
            }, {},{ })
        },

        
    ){
        ContentSearchView(navController, charactersVM)
    }
}

@Composable
fun ContentSearchView(navController: NavController, charactersVM: CharactersViewModel) {
    val characters by charactersVM.characters.collectAsState()
    var search by remember { mutableStateOf("") }
   Column(modifier = Modifier.padding(top = 80.dp)) {
       OutlineInputCustom(label = "Search name", value = search, onValueChange = {search = it})
       SpacerHeight()
       ButtonOutline(onClick = { charactersVM.fetchCharacter(search) }, text = "Search")
       LazyVerticalGrid(

           columns = GridCells.Fixed(3)
       ){
           items(characters.size) {index ->
               val item = characters[index]
               CardCustom(data = item) {
                   navController.navigate("Detail/${item.id}")
               }

           }
       }
   }



}


