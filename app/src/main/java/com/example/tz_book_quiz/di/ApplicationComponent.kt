package com.example.tz_book_quiz.di

import com.example.tz_book_quiz.presentation.MainActivity
import com.example.tz_book_quiz.presentation.fragments.GameFragment
import com.example.tz_book_quiz.presentation.fragments.MenuFragment
import com.example.tz_book_quiz.presentation.fragments.ResultFragment
import dagger.Component

@ApplicationScope
@Component(modules = [Module::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: GameFragment)
    fun inject(fragment: MenuFragment)
    fun inject(fragment: ResultFragment)
}