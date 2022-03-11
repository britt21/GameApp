package com.example.domain

import com.example.data.Games
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val gameApi: GameApi): Repository {
    override suspend fun getGames(): Response<Games> {
        return gameApi.getGames()
    }


}