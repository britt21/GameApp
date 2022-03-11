package com.example.domain.getGamesUseCase

import com.example.data.Games
import com.example.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getGames():Response<Games>{
        return  repository.getGames()

    }
}