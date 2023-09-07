package com.example.tz_book_quiz.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tz_book_quiz.data.model.Level
import com.example.tz_book_quiz.domain.usecases.GetCountOfCorrectAnswersUseCase
import com.example.tz_book_quiz.domain.usecases.GetLevelListUseCase
import javax.inject.Inject

class ResultViewModel @Inject constructor(
    private val getLevelListUseCase: GetLevelListUseCase,
    private val getCountOfCorrectAnswersUseCase: GetCountOfCorrectAnswersUseCase
) : ViewModel() {

    fun getLevelList(): List<Level> = getLevelListUseCase.invoke()

    fun getCountOfCorrectAnswers(): Int = getCountOfCorrectAnswersUseCase.invoke()
}