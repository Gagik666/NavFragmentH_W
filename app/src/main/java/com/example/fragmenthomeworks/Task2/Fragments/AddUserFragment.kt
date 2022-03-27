package com.example.fragmenthomeworks.Task2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.fragmenthomeworks.R


class AddUserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnStart = view.findViewById<Button>(R.id.btnStart)
        val btnExitAddUser = view.findViewById<Button>(R.id.btnExitAddUser)
        val edNameP1 = view.findViewById<EditText>(R.id.edNameP1)
        val edNameP2 = view.findViewById<EditText>(R.id.edNameP2)
        btnStart.setOnClickListener {

        }

        btnExitAddUser.setOnClickListener {

        }



    }

}