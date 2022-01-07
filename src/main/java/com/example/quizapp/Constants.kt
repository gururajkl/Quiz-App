package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            R.drawable.ic_flag_of_argentina,
            1,
            "Flag belongs to which country?",
            "Argentina",
            "Austina",
            "America",
            "Africa"
        )
        questionsList.add(que1)

        val que2 = Question(
            1,
            R.drawable.ic_flag_of_australia,
            3,
            "Flag belongs to which country?",
            "Argentina",
            "NewZealand",
            "Australia",
            "Africa"
        )
        questionsList.add(que2)

        val que3 = Question(
            1,
            R.drawable.ic_flag_of_belgium,
            1,
            "Flag belongs to which country?",
            "Belgium",
            "Austina",
            "America",
            "Baroda"
        )
        questionsList.add(que3)

        val que4 = Question(
            1,
            R.drawable.ic_flag_of_brazil,
            4,
            "Flag belongs to which country?",
            "Dubai",
            "Srilanka",
            "India",
            "Brazil"
        )
        questionsList.add(que4)

        val que5 = Question(
            1,
            R.drawable.ic_flag_of_denmark,
            2,
            "Flag belongs to which country?",
            "Pakisthan",
            "Denmark",
            "Soudi",
            "iran"
        )
        questionsList.add(que5)

        val que6 = Question(
            1,
            R.drawable.ic_flag_of_fiji,
            1,
            "Flag belongs to which country?",
            "fiji",
            "Denmark",
            "America",
            "India"
        )
        questionsList.add(que6)

        val que7 = Question(
            1,
            R.drawable.ic_flag_of_germany,
            4,
            "Flag belongs to which country?",
            "Argentina",
            "Austina",
            "America",
            "Germany"
        )
        questionsList.add(que7)

        val que8 = Question(
            1,
            R.drawable.ic_flag_of_india,
            1,
            "Flag belongs to which country?",
            "India",
            "Iran",
            "Iraq",
            "Japan"
        )
        questionsList.add(que8)

        val que9 = Question(
            1,
            R.drawable.ic_flag_of_kuwait,
            3,
            "Flag belongs to which country?",
            "Argentina",
            "Austina",
            "kuwait",
            "Africa"
        )
        questionsList.add(que9)

        val que10 = Question(
            1,
            R.drawable.ic_flag_of_new_zealand,
            1,
            "Flag belongs to which country?",
            "NewZealand",
            "Austina",
            "Australia",
            "Africa"
        )
        questionsList.add(que10)

        return questionsList
    }
}