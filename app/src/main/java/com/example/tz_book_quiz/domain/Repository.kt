package com.example.tz_book_quiz.domain

import com.example.tz_book_quiz.data.model.Level

interface Repository {

    fun getLevelByNumber(number: Int): Level
    fun savePlayerAnswer(number: Int, answer: Int)
    fun getLevelList(): List<Level>
    fun getCountOfCorrectAnswers(): Int
}