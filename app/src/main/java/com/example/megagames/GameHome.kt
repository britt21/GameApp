package com.example.megagames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.domain.NetworkResult
import com.example.megagames.databinding.FragmentGameHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameHome : Fragment() {

    lateinit var binding: FragmentGameHomeBinding
    lateinit var gameViewModel: GameViewModel
    private val gamesAdapter = GamesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
  binding = FragmentGameHomeBinding.inflate(inflater)

        binding.rvList.adapter = gamesAdapter
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        getGames()

        return binding.root
    }

    private fun getGames() {
        gameViewModel.getGames()
        gameViewModel.liveGames.observe(this, Observer { result ->
            when(result){

                is NetworkResult.Sucess ->{
                    gamesAdapter.submitList(result.data)
                }
                is  NetworkResult.Error ->{
                    Toast.makeText(requireContext(), result.message, Toast.LENGTH_SHORT).show()
                }

                // handle Loading using shimmer Effect!!!
            }
        })
    }


}