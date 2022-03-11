package com.example.megagames

import com.bumptech.glide.load.engine.Resource
import com.example.data.Games
import com.example.domain.GameApi
import com.example.domain.Repository
import com.example.domain.RepositoryImpl
import io.mockk.mockk
import org.junit.Before
import retrofit2.Response





class FakeRepository : Repository {

    val games = Games()

    override suspend fun getGames(): Response<Games> {
    return Response.success(games)

    }
}