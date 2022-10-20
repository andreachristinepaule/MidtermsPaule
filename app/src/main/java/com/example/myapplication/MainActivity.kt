package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentEditUserBinding
import com.example.myapplication.fragments.EditUserFragment
import com.example.myapplication.fragments.ViewFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editUserFragment = EditUserFragment();
        val fragmentManager = supportFragmentManager;
        fragmentManager.beginTransaction().replace(R.id.topFragment, editUserFragment).commit()

        val ViewFragment = ViewFragment();
        fragmentManager.beginTransaction().replace(R.id.botFragment, ViewFragment).commit()


        }

}