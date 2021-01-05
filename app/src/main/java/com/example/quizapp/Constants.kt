package com.example.quizapp

object Constants {

    const val user_name: String = "user_name"
    const val total_questions: String = "total_questions"
    const val correct_answers: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

         val q1 = Question(1,"Where was the electricity supply first introduced in India?",
                 "Mumbai", "Dehradun", "Chennai", "Darjeeling", 4)
         questionsList.add(q1)

        val q2 = Question(2,"Which one of the following river flows between Vindhyan and Satpura ranges?",
                "Narmada", "Mahanadi", "Son", "Netravati", 1)
        questionsList.add(q2)

        val q3 = Question(3,"Film and TV institute of India is located at?",
                "Pimpri", "Pune", "Perabur", "Rajkot", 2)
        questionsList.add(q3)

        val q4 = Question(4,"Where can Coral reefs be found in India?",
                "Malabar Coast", "Rameshwaram", "Trivandrum", "Mahabalipuram", 2)
        questionsList.add(q4)

        val q5 = Question(5,"Objects at the surface of water can be viewed from a submarine under water by using this instrument.",
                "Kaleidoscope", "Stethescope", "Telescope", "Periscope", 4)
        questionsList.add(q5)

        val q6 = Question(6," Professor Amartya Sen received the Nobel Prize in this field?",
                "Literature", "Electronics", "Economics", "Geology", 3)
        questionsList.add(q6)

        val q7 = Question(7,"The biggest part of the brain is?",
                "Cerebellum", "Spinal Cord", "Brain Stem", "Cerebrum", 4)
        questionsList.add(q7)

        val q8 = Question(8,"At room temperature, which is the only metal that is in liquid form?",
                "Mercury", "Iron", "Gold", "Aluminium", 1)
        questionsList.add(q8)

        val q9 = Question(9,"A change of the DNA of an organism resulting in a new trait is known as a ?",
                "Mitosis", "Mutation", "Meiosis", "Morphosis", 2)
        questionsList.add(q9)

        val q10 = Question(10,"Which organ of the human body does the Alzheimer’s disease affect?",
                "Ear", "Stomach", "Eye", "Brain", 4)
        questionsList.add(q10)

        return questionsList
    }
}