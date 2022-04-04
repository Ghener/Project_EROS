package com.example.automatedtaskscheduler

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.automatedtaskscheduler.databinding.ActivityMainBinding

public const val SPLASH_TIME = 4000L

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val firstTime = 0


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )
        Handler(Looper.myLooper()!!).postDelayed(
            {
                if(firstTime == 0) {
                    val intent = Intent(this, Setup::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    finish()
                }
            },
            SPLASH_TIME
        )

        val fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in_animation)

        binding.ivErosLogo.animation = fadeInAnim






    }
}