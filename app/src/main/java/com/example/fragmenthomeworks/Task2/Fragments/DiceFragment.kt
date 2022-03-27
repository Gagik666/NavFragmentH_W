package com.example.fragmenthomeworks.Task2.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmenthomeworks.R
import com.example.fragmenthomeworks.Task2.GamelLists
import kotlin.random.Random

class DiceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg: DiceFragmentArgs by navArgs()
        val btnSuffle = view.findViewById<Button>(R.id.btnSuffle)
        val btnExit = view.findViewById<Button>(R.id.btnExit)
        val btnMore = view.findViewById<Button>(R.id.btnMoreD)
        val btnResult = view.findViewById<Button>(R.id.btnResultD)
        var timerLeft: CountDownTimer? = null
        val tvRp1 = view.findViewById<TextView>(R.id.tvRP1)
        val tvRp2 = view.findViewById<TextView>(R.id.tvRP2)
        val tvNP1 = view.findViewById<TextView>(R.id.tvNP1)
        val tvNP2 = view.findViewById<TextView>(R.id.tvNP2)
        var l = 0
        var r = 0
        val imgDiceRight = view.findViewById<ImageView>(R.id.imgDiceRight)
        val imgDiceLeft = view.findViewById<ImageView>(R.id.imgDiceLeft)
        tvNP1.text = arg.player1
        tvNP2.text = arg.player2

        btnSuffle.setOnClickListener {
            var counterL = Random.nextInt(5)
            var counterR = Random.nextInt(5)
            timerLeft?.cancel()
            timerLeft = object : CountDownTimer(3000, 80) {
                override fun onTick(p0: Long) {
                    counterL++
                    if (counterL > 5) counterL = 0
                    imgDiceLeft.setImageResource(GamelLists.imgDiceList[counterL])
                    counterR++
                    if (counterR > 5) counterR = 0
                    imgDiceRight.setImageResource(GamelLists.imgDiceList[counterR])

                }
                override fun onFinish() {
                    if (counterL + 1 > counterR + 1) l++
                    if (counterR + 1 > counterL + 1) r++
                    tvRp1.text = l.toString()
                    tvRp2.text = r.toString()
                }
            }.start()
        }


        btnExit.setOnClickListener {
            findNavController().navigate(R.id.action_diceFragment_to_mainFragment)
        }

        btnResult.setOnClickListener {
            findNavController().navigate(DiceFragmentDirections.actionDiceFragmentToGameRes(
                tvNP1.text.toString(), tvNP2.text.toString(),
                tvRp1.text.toString().toInt(), tvRp2.text.toString().toInt(), "D I C E"))
        }

        btnMore.setOnClickListener {
            findNavController().navigate(R.id.action_diceFragment_to_gamesFragment)
        }

    }
}