package com.example.marvelapp.state

import com.example.marvelapp.model.ComicsItem
import com.example.marvelapp.model.StoriesItem
import com.example.marvelapp.model.URLs


data class MarvelState(
    val offset: Long = 0,
    val limit: Long  = 0,
    val total: Long = 0,
    val count: Long = 0,
    val results: List<MarvelResultsState> = listOf()
)

data class MarvelResultsState(
    val id: Long  = 0,
    val name: String = "",
    val description: String = "",
    val modified: String = "",
    val thumbnail: ThumbnailState = ThumbnailState("", ""),
    val resourceURI: String = "",
    val comics: ComicsState = ComicsState(0, "", listOf(), 0),
    val series: ComicsState = ComicsState(0, "", listOf(), 0),
    val stories: StoriesState = StoriesState(0,"", listOf(), 0),
    val events: ComicsState = ComicsState(0, "", listOf(), 0),
    val urls: List<URLs> = listOf()
)

data class ComicsState(
    val available: Long  = 0,
    val collectionURI: String = "",
    val items: List<ComicsItem> = listOf(),
    val returned: Long  = 0
)

data class StoriesState(
    val available: Long  = 0,
    val collectionURI: String = "",
    val items: List<StoriesItem> = listOf(),
    val returned: Long = 0
)

data class ThumbnailState (
    val path: String = "",
    val extension: String = ""
)
