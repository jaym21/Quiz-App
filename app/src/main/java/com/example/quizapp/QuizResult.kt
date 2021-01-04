package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quiz_result.*

class QuizResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        val userName = intent.getStringExtra(Constants.user_name)
        tvCongratsName.text = "Congratulations ${userName}!"

        val totalQuestions = intent.getIntExtra(Constants.total_questions, 0)
        val correctAnswers = intent.getIntExtra(Constants.correct_answers, 0)

        tvScore.text = "Your Score is ${correctAnswers} out of ${totalQuestions}"

        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}