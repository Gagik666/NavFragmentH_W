package com.example.fragmenthomeworks.Task2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.fragmenthomeworks.R

class MainFragment : Fragment() {
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnFirstTask = view.findViewById<Button>(R.id.btnFirstTask)

        val btnSecondTask = view.findViewById<Button>(R.id.btnSecondTask)
        btnSecondTask.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_gamesFragment)
        }
        btnFirstTask.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_firstFragment)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}