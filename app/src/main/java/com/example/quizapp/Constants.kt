package com.example.quizapp

object Constants {

    const val user_name: String = "user_name"
    const val total_questions: String = "total_questions"
    const val correct_answers: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

         val q1 = Question(1,"What is the color of sun?", "Red",
             "Yellow", "Green", "Black", 2)
         questionsList.add(q1)

        val q2 = Question(1,"What is the color of sun?", "Red",
            "Yellow", "Green", "Black", 2)
        questionsList.add(q2)

        val q3 = Question(1,"What is the color of sun?", "Red",
            "Yellow", "Green", "Black", 2)
        questionsList.add(q3)

        val q4 = Question(1,"What is the color of sun?", "Red",
            "Yellow", "Green", "Black", 2)
        questionsList.add(q4)

        return questionsList
    }
}