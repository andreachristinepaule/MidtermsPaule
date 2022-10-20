package com.example.myapplication.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.MainActivity
import com.example.myapplication.PREFERENCE
import com.example.myapplication.R
import com.example.myapplication.USERNAME
import com.example.myapplication.databinding.FragmentEditUserBinding

class EditUserFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentEditUserBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditUserBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE)
        binding.btnSaveUser.setOnClickListener(this)
        return view
    }

    override fun onClick(p0: View?) {
        val edit = sharedPreferences.edit()
        when(p0!!.id){
            (R.id.btn_save_user)->{
                if(binding.txtEditUser.text.toString() == ""){
                    binding.txtEditUser.error = "REQUIRED!"
                }
                else if(binding.txtEditUser.text.length < 6){
                    binding.txtEditUser.error = "NOT ENOUGH CHARACTERS!"
                }
                else{
                    edit.putString(USERNAME,binding.txtEditUser.text.toString())
                    edit.apply()
                    val i = Intent(this.context, MainActivity::class.java)
                    this.context?.startActivity(i)
                }
            }
        }
    }
}