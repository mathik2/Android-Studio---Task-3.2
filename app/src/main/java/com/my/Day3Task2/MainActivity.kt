package com.my.Day3Task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.my.day3task1.R
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var RandomNumber = Random.nextInt(0,1000)
    var count=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton= findViewById<TextView>(R.id.clickButton)
        val typeValue=findViewById<TextInputLayout>(R.id.typeText)
        val guess=findViewById<TextView>(R.id.guessView)

        clickButton.setOnClickListener{
            try {
                val inputValue  = typeValue.editText?.text.toString()
                val GuessedValue=Integer.parseInt(inputValue)

                val value=
                    if(GuessedValue<0)
                    {
                        count++
                        "Please Enter A Positive Number"

                    }
                    else if(GuessedValue<RandomNumber )
                    {
                    count++
                        "No :( My Number is bigger"
                    }
                    else if(GuessedValue>RandomNumber )
                    {
                        count++
                        "NO :| My number is smaller"
                    }
                    else
                    {
                        val winScreenIntent=Intent(this, WonActivity::class.java)
                        winScreenIntent.putExtra("numberIs",RandomNumber )
                        startActivity(winScreenIntent)
                        "you won!! :)"

                    }
                guess.text="$value"
                if(count==12)
                {
                    val finalActivityIntent=Intent(this, FinalActivity::class.java)
                    finalActivityIntent.putExtra("numberIs",RandomNumber )
                    startActivity(finalActivityIntent)
                }
            }
            catch (e:Exception)
            {
               guess.text="Please Enter A Number"
            }



        }
    }
}