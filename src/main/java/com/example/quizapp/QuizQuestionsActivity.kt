package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var myCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null


    @SuppressLint("SetTextI18n", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions_acitvity)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)


        //calling the object's function
        mQuestionList = Constants.getQuestion()

        setQuestion()

        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        op4.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        //getting the id's
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val progressText = findViewById<TextView>(R.id.tv_progress)
        val questionText = findViewById<TextView>(R.id.tv_question_id)
        val image = findViewById<ImageView>(R.id.iv_image)
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)



        val question: Question? = mQuestionList!![myCurrentPosition - 1]  //initially starts with 0 and continues further (because it is an array)

        defaultOptionView()

        if(myCurrentPosition == mQuestionList!!.size) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }


        //setting all the texts to dynamic texts using data class Question
        progressBar.progress = myCurrentPosition
        progressText.text = "$myCurrentPosition" + "/" + progressBar.max
        questionText.text = question!!.question
        image.setImageResource(question.image)
        op1.text = question.optionOne
        op2.text = question.optionTwo
        op3.text = question.optionThree
        op4.text = question.optionFour
    }

    private fun defaultOptionView() {
       val options = ArrayList<TextView>()
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        options.add(0, op1)
        options.add(1, op2)
        options.add(2, op3)
        options.add(3, op4)

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_background
            )
        }

    }

    override fun onClick(v: View?) {
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)


        when(v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(op1, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(op2, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(op3, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(op4, 4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0) {
                    myCurrentPosition ++

                    when {
                        myCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        } else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(myCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_background)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_background)

                    if(myCurrentPosition == mQuestionList!!.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val op1 = findViewById<TextView>(R.id.tv_option_one)
        val op2 = findViewById<TextView>(R.id.tv_option_two)
        val op3 = findViewById<TextView>(R.id.tv_option_three)
        val op4 = findViewById<TextView>(R.id.tv_option_four)

        when(answer) {
            1 -> {
                op1.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                op2.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                op3.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                op4.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_background
        )
    }
}
