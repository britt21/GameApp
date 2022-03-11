package com.example.domain

import com.example.data.Games
import retrofit2.Response

interface Repository {

    suspend fun getGames(): Response<Games>

}