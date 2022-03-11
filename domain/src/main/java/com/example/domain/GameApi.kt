package com.example.domain

import com.example.data.Games
import retrofit2.Response
import retrofit2.http.GET

// https://www.gamerpower.com/api/giveaways


interface GameApi {

    @GET("/api/giveaways")
    suspend  fun getGames(): Response<Games>
}