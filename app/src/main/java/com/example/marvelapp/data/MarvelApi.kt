package com.example.marvelapp.data

import com.example.marvelapp.model.CharactersModels
import com.example.marvelapp.utils.Constants.Companion.PUBLIC_KEY
import com.example.marvelapp.utils.GeneratorMD5.Companion.createHash


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters(
        @Query("name") name: String,
        @Query("offset") offset: Int,
        @Query("apikey") publicKey: String = PUBLIC_KEY,
        @Query("ts") ts: String = createHash()["code"].toString(),
        @Query("hash") has: String = createHash()["hash"].toString(),

    ): Response<CharactersModels>

    @GET("characters")
    suspend fun getCharactersPages(
        @Query("offset") offset: Int,
        @Query("apikey") publicKey: String = PUBLIC_KEY,
        @Query("ts") ts: String = createHash()["code"].toString(),
        @Query("hash") has: String = createHash()["hash"].toString(),

    ): CharactersModels

    @GET("characters/{id}")
    suspend fun getCharacterById(
        @Path(value = "id") id : Int,
        @Query("apikey") publicKey: String = PUBLIC_KEY,
        @Query("ts") ts: String = createHash()["code"].toString(),
        @Query("hash") has: String = createHash()["hash"].toString(),
    ): Response<CharactersModels>

}



