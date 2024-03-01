package com.example.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacters(): Response<List<Character>>

    @GET("characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Int): Response<Character>
}