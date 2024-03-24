package com.example.marvelapp.model

data class CharactersModels (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: MarvelData
)

data class MarvelData (
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<MarvelResults>
)

data class MarvelResults (
    val id: Long,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comics,
    val series: Comics,
    val stories: Stories,
    val events: Comics,
    val urls: List<URLs>
)

data class Comics (
    val available: Long,
    val collectionURI: String,
    val items: List<ComicsItem>,
    val returned: Long
)

data class ComicsItem (
    val resourceURI: String,
    val name: String
)

data class Stories (
    val available: Long,
    val collectionURI: String,
    val items: List<StoriesItem>,
    val returned: Long
)

data class StoriesItem (
    val resourceURI: String,
    val name: String,
    val type: String
)

data class Thumbnail (
    val path: String,
    val extension: String
)


data class URLs (
    val type: String,
    val url: String
)