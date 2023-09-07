package com.example.tz_book_quiz

import android.app.Application
import com.example.tz_book_quiz.di.ApplicationComponent
import com.example.tz_book_quiz.di.DaggerApplicationComponent

class BookQuizApp : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .build()
    }
}