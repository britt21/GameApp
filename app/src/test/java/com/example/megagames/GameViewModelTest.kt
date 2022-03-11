package com.example.megagames

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.getGamesUseCase.GetGamesUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After

import org.junit.Before
import org.junit.Rule
import org.junit.Test


//add instant Task Executor Rule

@ExperimentalCoroutinesApi
class GameViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //provide Repository
    lateinit var getGamesUseCase: GetGamesUseCase
    lateinit var viewModel: GameViewModel
    lateinit var fakeRepository: FakeRepository
    val dispatcher = TestCoroutineDispatcher()



    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        fakeRepository = FakeRepository()
        getGamesUseCase = GetGamesUseCase(fakeRepository)
        viewModel = GameViewModel(getGamesUseCase)

    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `Test that live data is being observed`(){
        viewModel.getGames()
        val result = viewModel.liveGames.getOrAwaitValue()

        assertThat(result).isNotEqualTo(null)
    }

}