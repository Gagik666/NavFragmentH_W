package com.example.fragmenthomeworks.Task2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.fragmenthomeworks.R


class GamesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val btnExitGame = view.findViewById<Button>(R.id.btnExitGames)
        val btnStartDice = view.findViewById<Button>(R.id.btnStartGameD)
        val btnStartTicTacToe = view.findViewById<Button>(R.id.btnStartGameT)
        val edPlayer1D = view.findViewById<EditText>(R.id.edPlayer1D)
        val edPlayer2D = view.findViewById<EditText>(R.id.edPlayer2D)
        val edPlayer1T = view.findViewById<EditText>(R.id.edPlayer1T)
        val edPlayer2T = view.findViewById<EditText>(R.id.edPlayer2T)

        btnExitGame.setOnClickListener {
            findNavController().navigate(R.id.action_gamesFragment_to_mainFragment)
        }

        btnStartDice.setOnClickListener {
            findNavController().navigate(GamesFragmentDirections.actionGamesFragmentToDiceFragment(
                edPlayer1D.text.toString(), edPlayer2D.text.toString()
            ))
        }

        btnStartTicTacToe.setOnClickListener {
            findNavController().navigate(GamesFragmentDirections.actionGamesFragmentToTicTacToeFragment(
                edPlayer1T.text.toString(), edPlayer2T.text.toString()
            ))
        }

    }


}