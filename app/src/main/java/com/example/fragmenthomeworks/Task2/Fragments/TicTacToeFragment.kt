package com.example.fragmenthomeworks.Task2.Fragments

import android.graphics.Color
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

class TicTacToeFragment : Fragment() {
    private val arg: TicTacToeFragmentArgs by navArgs()
    var player = true
    lateinit var tvNP1: TextView
    lateinit var tvNP2: TextView
    lateinit var tvRP1: TextView
    lateinit var tvRP2: TextView
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var tvWin: TextView
    var countR1 = 0
    var countR2 = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_tic_tac_toe, container, false)
            tvNP1 = view.findViewById(R.id.tvNP1)
            tvNP2 = view.findViewById(R.id.tvNP2)
            tvRP1 = view.findViewById(R.id.tvRP1)
            tvRP2 = view.findViewById(R.id.tvRP2)
            btn1 = view.findViewById(R.id.btn1)
            btn2 = view.findViewById(R.id.btn2)
            btn3 = view.findViewById(R.id.btn3)
            btn4 = view.findViewById(R.id.btn4)
            btn5 = view.findViewById(R.id.btn5)
            btn6 = view.findViewById(R.id.btn6)
            btn7 = view.findViewById(R.id.btn7)
            btn8 = view.findViewById(R.id.btn8)
            btn9 = view.findViewById(R.id.btn9)
            tvWin = view.findViewById(R.id.tvWin)
        val btnExit = view.findViewById<Button>(R.id.btnExitT)
        val btnResult = view.findViewById<Button>(R.id.btnResultT)
        val btnMore = view.findViewById<Button>(R.id.btnMoreT)

        btnExit.setOnClickListener {
            findNavController().navigate(R.id.action_ticTacToeFragment_to_mainFragment)
        }

        btnMore.setOnClickListener {
            findNavController().navigate(R.id.action_ticTacToeFragment_to_gamesFragment)
        }

        btnResult.setOnClickListener {
            findNavController().navigate(TicTacToeFragmentDirections.actionTicTacToeFragmentToGameRes(
                tvNP1.text.toString(), tvNP2.text.toString(),
                tvRP1.text.toString().toInt(), tvRP2.text.toString().toInt(),
                "TIC TAC TOE"
            ))
        }

        tvNP1.text = arg.name1
        tvNP2.text = arg.name2

        btn1.setOnClickListener {
            btnClick(btn1)
        }

        btn2.setOnClickListener {
            btnClick(btn2)
        }

        btn3.setOnClickListener {
            btnClick(btn3)
        }

        btn4.setOnClickListener {
            btnClick(btn4)
        }

        btn5.setOnClickListener {
            btnClick(btn5)
        }

        btn6.setOnClickListener {
            btnClick(btn6)
        }

        btn7.setOnClickListener {
            btnClick(btn7)
        }

        btn8.setOnClickListener {
            btnClick(btn8)
        }

        btn9.setOnClickListener {
            btnClick(btn9)
        }

        return view
    }

    fun btnClick(btn: Button) {
        if (player) {
            btn.text = "X"
            tvNP2.setTextColor(Color.GREEN)
            tvNP1.setTextColor(Color.BLACK)
            player = false
        } else {
            btn.text = "O"
            tvNP2.setTextColor(Color.BLACK)
            tvNP1.setTextColor(Color.GREEN)
            player = true
        }
        btn.isClickable = false
        win()
    }

    fun win() {
        if (btn1.text == "X" && btn2.text == "X" && btn3.text == "X") {
            winResult(btn1, btn2, btn3)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn1.text == "O" && btn2.text == "O" && btn3.text == "O") {
            winResult(btn1, btn2, btn3)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
        if (btn4.text == "X" && btn5.text == "X" && btn6.text == "X") {
            winResult(btn4, btn5, btn6)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn4.text == "O" && btn5.text == "O" && btn6.text == "O") {
            winResult(btn4, btn5, btn6)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
        if (btn7.text == "X" && btn8.text == "X" && btn9.text == "X") {
            winResult(btn7, btn8, btn9)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn7.text == "O" && btn8.text == "O" && btn9.text == "O") {
            winResult(btn7, btn8, btn9)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
        if (btn1.text == "X" && btn4.text == "X" && btn7.text == "X") {
            winResult(btn1, btn4, btn7)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn1.text == "O" && btn4.text == "O" && btn7.text == "O") {
            winResult(btn1, btn4, btn7)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
        if (btn2.text == "X" && btn5.text == "X" && btn8.text == "X") {
            winResult(btn2, btn5, btn8)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn2.text == "O" && btn5.text == "O" && btn8.text == "O") {
            winResult(btn2, btn5, btn8)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
        if (btn3.text == "X" && btn6.text == "X" && btn9.text == "X") {
            winResult(btn3, btn6, btn9)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn3.text == "O" && btn6.text == "O" && btn9.text == "O") {
            winResult(btn3, btn6, btn9)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
        if (btn1.text == "X" && btn5.text == "X" && btn9.text == "X") {
            winResult(btn1, btn5, btn9)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn1.text == "O" && btn5.text == "O" && btn9.text == "O") {
            winResult(btn1, btn5, btn9)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
        if (btn3.text == "X" && btn5.text == "X" && btn7.text == "X") {
            winResult(btn3, btn5, btn7)
            countR1++
            tvRP1.text = countR1.toString()
            Win1()
        }
        if (btn3.text == "O" && btn5.text == "O" && btn7.text == "O") {
            winResult(btn3, btn5, btn7)
            countR2++
            tvRP2.text = countR2.toString()
            Win2()
        }
    }

    fun winResult(b1: Button, b2: Button, b3: Button) {
        b1.text = "W"
        b2.text = "I"
        b3.text = "N"

    }

    fun Win1() {
        tvWin.text = "WIN ${tvNP1.text}"
        tvWin.visibility = View.VISIBLE
    }

    fun Win2() {
        tvWin.text = "WIN ${tvNP2.text}"
        tvWin.visibility = View.VISIBLE
    }

}