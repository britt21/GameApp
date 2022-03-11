package com.example.megagames

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GameHomeTest{

    lateinit var gameHome: GameHome

    @Before
    fun setup(){
        gameHome = GameHome()
    }


    @Test
    fun launch_fragment_perform_click(){
        launchFragmentInHiltContainer<GameHome> {  }

    }
}