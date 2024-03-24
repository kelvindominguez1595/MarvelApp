package com.example.marvelapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.marvelapp.components.FontSize
import com.example.marvelapp.components.LabelCustom
import com.example.marvelapp.components.SpacerHeight
import com.example.marvelapp.components.TopTapBarCustom
import com.example.marvelapp.utils.GeneratorMD5
import com.example.marvelapp.viewModels.CharactersViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, charactersVM: CharactersViewModel, id: Int) {
    val characterDetails = charactersVM.characterDetails
    LaunchedEffect(Unit){
        charactersVM.getCharacterById(id)
    }

    DisposableEffect(Unit ){
        onDispose {
            charactersVM.cleanDetail()
        }
    }

    Scaffold(
        modifier = Modifier.background(Color.White),
        topBar = {
            TopTapBarCustom(title = "Characters: ${characterDetails.name}", true, true,false, {
                navController.navigate("Home")
            }, {
                navController.navigate("Search")
            },{
                navController.navigate("Login")
            })
        }
    ){
        ContentDetailView(navController, charactersVM)
    }
    
}

@Composable
fun ContentDetailView(navController: NavController, charactersVM: CharactersViewModel) {
    val scrollColum = rememberScrollState(0)
    val characterDetails = charactersVM.characterDetails

    Column (modifier = Modifier
        .verticalScroll(scrollColum)
        .padding(top = 60.dp)
    ){
        val posterMain = GeneratorMD5.convertToHttps(characterDetails.thumbnail.path)
        AsyncImage(
            model = "${posterMain}.${characterDetails.thumbnail.extension}",
            contentDescription = characterDetails.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        SpacerHeight(10.dp)
        LabelCustom(text = characterDetails.name, fontSize = FontSize.Title, fontWeight = FontWeight.Bold)
        SpacerHeight(10.dp)
        LabelCustom(text = characterDetails.description, fontSize = FontSize.Body)
        SpacerHeight(10.dp)
        LabelCustom(text = "Comics", fontSize = FontSize.Title, fontWeight = FontWeight.Bold)
        SpacerHeight(10.dp)
        LazyRow{
            items(characterDetails.comics.items) {
                item -> Card (modifier = Modifier.padding(horizontal = 10.dp)) {
                LabelCustom(text = item.name, fontSize = FontSize.Body)
            }
            }
        }
        SpacerHeight(10.dp)
        LabelCustom(text = "Series", fontSize = FontSize.Title , fontWeight = FontWeight.Bold)
        SpacerHeight(10.dp)
        LazyRow{
            items(characterDetails.series.items) {
                item -> Card (modifier = Modifier.padding(horizontal = 10.dp)) {
                LabelCustom(text = item.name, fontSize = FontSize.Body)
            }
            }
        }
        SpacerHeight(70.dp)
    }
}