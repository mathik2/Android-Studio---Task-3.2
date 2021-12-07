package com.my.Day3Task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.my.day3task1.R

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost)
        var correctAnswer=intent.getIntExtra("numberIs",0)
        findViewById<TextView>(R.id.answerView1).text="$correctAnswer"

    }
}