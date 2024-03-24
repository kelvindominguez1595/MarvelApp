package com.example.marvelapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvelapp.model.MarvelResults
import com.example.marvelapp.utils.GeneratorMD5.Companion.convertToHttps


@Composable
fun CardCustom(data: MarvelResults, onClick: () -> Unit) {
    Card(shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(10.dp)
            .clickable { onClick() }
    ) {
    Column (

        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val convertUrl = convertToHttps(data.thumbnail.path)
        AsyncImage(
            model = "${convertUrl}.${data.thumbnail.extension}",
            contentDescription = data.name,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        LabelCustom(text = data.name, fontSize = FontSize.Caption, fontWeight = FontWeight.Bold)
        LabelCustom(text = data.modified, fontSize = FontSize.Overline)
        }
    }
}


