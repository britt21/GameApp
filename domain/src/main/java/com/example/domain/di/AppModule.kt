package com.example.domain.di

import com.example.data.common.Constants.Companion.BASE_URL
import com.example.domain.GameApi
import com.example.domain.Repository
import com.example.domain.RepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideGamesApi(retrofit: Retrofit): GameApi{
        return retrofit.create(GameApi::class.java)
    }

@Singleton
@Provides
fun getRepository(gameApi: GameApi): Repository{
    return RepositoryImpl(gameApi)
}


}