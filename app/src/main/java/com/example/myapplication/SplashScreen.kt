package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("MY_PREFERENCES", MODE_PRIVATE)

        val username = sharedPreferences.getString(USERNAME, "").toString()
        supportActionBar?.hide()

        if(username == "") {
            binding.txtAppWelcome.text = "WELCOME TO MY APPLICATION!"
        }
        else{
            binding.txtAppWelcome.text = "WELCOME TO MY APPLICATION\n$username";
        }

        object : CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                    val intent = Intent(this@SplashScreen,MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            } .start()
        }
    }