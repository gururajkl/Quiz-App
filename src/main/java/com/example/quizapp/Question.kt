package com.example.quizapp

data class Question (
    val id: Int,
    val image: Int,
    val correctAnswer: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String
)
