package com.example.fragmenthomeworks.Task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmenthomeworks.R

class SecondFragment : Fragment() {
    private val arg: SecondFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnExitSecond = view.findViewById<Button>(R.id.btnExitSecond)
        val btnBackSecond = view.findViewById<Button>(R.id.btnBackSecond)
        val tvResult = view.findViewById<TextView>(R.id.tvResult)
        tvResult.text = arg.result
        btnExitSecond.setOnClickListener {
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToMainFragment())
        }

        btnBackSecond.setOnClickListener {
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
        }
    }


}