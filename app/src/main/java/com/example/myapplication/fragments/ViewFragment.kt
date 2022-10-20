package com.example.myapplication.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.PREFERENCE
import com.example.myapplication.R
import com.example.myapplication.USERNAME
import com.example.myapplication.databinding.FragmentEditUserBinding
import com.example.myapplication.databinding.FragmentViewBinding

class ViewFragment : Fragment() {
    private lateinit var binding: FragmentViewBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        val username = sharedPreferences.getString(USERNAME,"").toString()
        binding.txtUser.text = "USERNAME: "+username
        return view
    }
}