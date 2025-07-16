package com.example.summerpractice2025.homework_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.SummerPractice2025.homework_1.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }
}