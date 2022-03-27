package com.example.fragmenthomeworks.Task2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmenthomeworks.R

class GameResFragment : Fragment() {
    private val arg: GameResFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_game_res, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvName1 = view.findViewById<TextView>(R.id.tvName1)
        val tvName2 = view.findViewById<TextView>(R.id.tvName2)
        val tvRes1 = view.findViewById<TextView>(R.id.tvRes1)
        val tvRes2 = view.findViewById<TextView>(R.id.tvRes2)
        val tvGName = view.findViewById<TextView>(R.id.tvGName)
        val btnMore = view.findViewById<Button>(R.id.btnMoreRes)
        val btnAgain = view.findViewById<Button>(R.id.btnAgain)
        val btnExit = view.findViewById<Button>(R.id.btnExitRes)



        tvName1.text = arg.n1
        tvName2.text = arg.n2
        tvRes1.text = arg.r1.toString()
        tvRes2.text = arg.r2.toString()
        tvGName.text = arg.gName

        btnMore.setOnClickListener {
            findNavController().navigate(R.id.action_gameRes_to_gamesFragment)
        }

        btnAgain.setOnClickListener {

            if (tvGName.text.toString() == "D I C E") {
                findNavController().navigate(GameResFragmentDirections.actionGameResToDiceFragment2(
                    tvName1.text.toString(), tvName2.text.toString()
                ))
            }

            if (tvGName.text.toString() == "TIC TAC TOE") {
                findNavController().navigate(GameResFragmentDirections.actionGameResToTicTacToeFragment(
                    tvName1.text.toString(), tvName2.text.toString()
                ))
            }

        }

        btnExit.setOnClickListener {
            findNavController().navigate(R.id.action_gameRes_to_mainFragment)
        }
    }

}