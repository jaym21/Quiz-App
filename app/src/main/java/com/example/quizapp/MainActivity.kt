package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            if (etName.text.toString().isNotEmpty()) {
                val intent = Intent(this, QuizQuestions::class.java)
                //sending the user's name to the next activity i.e QuizQuestions with user_name as id
                intent.putExtra(Constants.user_name, etName.text.toString())
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Enter a Name", Toast.LENGTH_LONG).show()
            }
        }
    }
}