package com.example.megagames

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnit


@HiltAndroidTest
@MediumTest
class GameHomeTest{

    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Mock
    var navcontroller = mock(NavController::class.java)

    @get:Rule
    var mockRule = MockitoJUnit.rule()


    @Test
    fun launch_fragment_perform_click(){
        launchFragmentInHiltContainer<GameHome> {
            Navigation.setViewNavController(requireView(), navcontroller)


        }
        Thread.sleep(5000)
        onView(withId(R.id.rv_list)).perform(
            RecyclerViewActions.actionOnItemAtPosition<GamesAdapter.GamesViewHolder>(
            0, click()
        ))


    }


}