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
import com.example.fragmenthomeworks.R



class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnExit = view.findViewById<Button>(R.id.btnExit)
        val btnGoTo = view.findViewById<Button>(R.id.btnGoTo)
        val edinput = view.findViewById<EditText>(R.id.edInput)

        btnExit.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToMainFragment())
        }

        btnGoTo.setOnClickListener {
            view.findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                "Result ->  ${edinput.text}"
            ))
        }
    }

}