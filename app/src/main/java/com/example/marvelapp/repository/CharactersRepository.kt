package com.example.marvelapp.repository

import com.example.marvelapp.data.MarvelApi
import com.example.marvelapp.model.CharactersModels
import com.example.marvelapp.model.MarvelData
import com.example.marvelapp.model.MarvelResults
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val marvelApi: MarvelApi) {
    suspend fun getCharacters(name: String): List<MarvelResults>? {
        val response = marvelApi.getCharacters(name, offset = 0)

        if(response.isSuccessful){
            return response.body()?.data?.results
        }
        return null
    }

    suspend fun getCharactersPage(page: Int): CharactersModels {
        return marvelApi.getCharactersPages(offset = page)
    }

    suspend fun getCharacterById(id: Int): MarvelData? {
        val response = marvelApi.getCharacterById(id)
        if(response.isSuccessful){
            return response.body()?.data
        }
        return null
    }
}