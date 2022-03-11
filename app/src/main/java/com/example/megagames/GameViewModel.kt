package com.example.megagames

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Games
import com.example.domain.NetworkResult
import com.example.domain.getGamesUseCase.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(private val getGamesUseCase: GetGamesUseCase) : ViewModel() {

    private val _liveGames = MutableLiveData<NetworkResult<Games>>()
    val liveGames: LiveData<NetworkResult<Games>>
        get() = _liveGames

    fun getGames() {
        viewModelScope.launch {
            try {


            val response = getGamesUseCase.getGames()
            _liveGames.value = handleGamesResponse(response)
        }catch (e: Exception){


            }
        }
    }

    private fun handleGamesResponse(response: Response<Games>): NetworkResult<Games>? {

        
            when {
                response.isSuccessful -> {
                    val result = response.body()
                    return NetworkResult.Sucess(result!!)
                }

                response.code() == 404 -> {
                    return NetworkResult.Error("No Result found")
                }
                else -> {
                    return NetworkResult.Error("An Unexpected Error Occured")
                }
            }

    }

    }


