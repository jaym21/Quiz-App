package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mUserName: String? = null
    private var mQuestionsList: ArrayList<Question>? = null
    private var mCurrentPosition: Int = 1
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.user_name)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)

        btnSubmit.setOnClickListener(this)
    }

    //this function will put the current question and options for that question on the screen
    private fun setQuestion() {

        if(mCurrentPosition == mQuestionsList!!.size) {
            //when we are at last question then changing button to finish
            btnSubmit.text = "FINISH"
        }else{
            //when we are not at last question then changing it ro Submit for the correct question being displayed
            btnSubmit.text = "SUBMIT"
        }
        val question = mQuestionsList!!.get(mCurrentPosition-1) //minus 1 is put because mQuestionList is an ArrayList and index starts from 0 in it
        //setting the default option view while setting up the question and options
        defaultOptionView()

        progressBar.progress = mCurrentPosition

        tvQuestion.text = question!!.question
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }

    //the default view that options will have when not selected
    private fun defaultOptionView() {
        //making an arraylist of options to loop through and set view
        val options = ArrayList<TextView>()
        options.add(0,tvOptionOne)
        options.add(1,tvOptionTwo)
        options.add(2,tvOptionThree)
        options.add(3,tvOptionFour)

        //setting the default option view for the options
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            //setting typeface(typefaces are bold, italic, normal) as default
            option.typeface = Typeface.DEFAULT
            //setting default background drawable created
            option.background = ContextCompat.getDrawable(this, R.drawable.option_shape)
        }
    }

    override fun onClick(v: View?) {
        //changing the view of the options when clicked
        when(v?.id) {
            R.id.tvOptionOne -> selectedOptionView(tvOptionOne, 1)
            R.id.tvOptionTwo -> selectedOptionView(tvOptionTwo, 2)
            R.id.tvOptionThree -> selectedOptionView(tvOptionThree, 3)
            R.id.tvOptionFour -> selectedOptionView(tvOptionFour, 4)

            R.id.btnSubmit -> {
                //user did not select any option
                if (mSelectedOptionPosition == 0) {
                    //going to the next question by increasing the current position
                    mCurrentPosition++

                    when{
                        //checking if after going to next question we are still less then the no.of questions present
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            //if we are less then setting the next question
                            setQuestion()
                        }else -> {
                            //if we are greater than no.of questions that means the quiz is completed
                            val intent = Intent(this, QuizResult::class.java)
                            //passing the user's name to result activity where we need to display it
                            intent.putExtra(Constants.user_name, mUserName)
                            //passing no.of answers that were correct
                            intent.putExtra(Constants.correct_answers, mCorrectAnswers)
                            //passing total no.of questions
                            intent.putExtra(Constants.total_questions, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{ //when user has selected an option
                    //getting the current question we are on
                    val question = mQuestionsList?.get(mCurrentPosition-1)

                    //when selected option is not correct one
                    if (question!!.correctOption != mSelectedOptionPosition) {
                        onSubmitView(mSelectedOptionPosition, R.drawable.wrong_option)
                    }else{
                        //if answer was correct
                        mCorrectAnswers++
                    }
                    //even if wrong option is selected each time we need to highlight the correct option
                    onSubmitView(question.correctOption, R.drawable.correct_option)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        //when we are at last question then changing button to finish
                        btnSubmit.text = "FINISH"
                    }else{
                        //when there are questions left then changing it to next
                        btnSubmit.text = "NEXT"
                    }
                    //setting the selected option back to 0 as we need to go to the next question when correct option is displayed
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    //this function will change the view of the selected option
    private fun selectedOptionView(tv: TextView, selectedOption: Int) {
        //first setting all the options to default view,
        // because if the user clicks 1 option then again clicks on other options should have default view including previously selected option
        defaultOptionView()
        //setting the position of selected option
        mSelectedOptionPosition = selectedOption

        //setting the selected option view
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option)
    }

    //this will make the correct answer option view change to green and if the wrong one is selected then red
    private fun onSubmitView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            2 -> tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)

        }
    }
}