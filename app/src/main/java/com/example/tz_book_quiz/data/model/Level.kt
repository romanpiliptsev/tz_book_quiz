package com.example.tz_book_quiz.data.model

data class Level(
    val number: Int,
    val text: String,
    val correctAnswer: Int,
    val imageList: List<Int>,
    var playerAnswer: Int = 0
)