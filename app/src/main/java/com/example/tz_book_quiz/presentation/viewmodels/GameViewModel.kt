package com.example.tz_book_quiz.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tz_book_quiz.data.model.Level
import com.example.tz_book_quiz.domain.usecases.GetLevelByNumberUseCase
import com.example.tz_book_quiz.domain.usecases.SavePlayerAnswerUseCase
import javax.inject.Inject

class GameViewModel @Inject constructor(
    private val getLevelByNumberUseCase: GetLevelByNumberUseCase,
    private val savePlayerAnswerUseCase: SavePlayerAnswerUseCase
) : ViewModel() {

    private val _getLevelLiveData = MutableLiveData<Level>()
    val getLevelLiveData: LiveData<Level>
        get() = _getLevelLiveData

    fun getLevelByNumber(levelNumber: Int) {
        _getLevelLiveData.value = getLevelByNumberUseCase.invoke(levelNumber)
    }

    fun savePlayerAnswer(number: Int, answer: Int) {
        savePlayerAnswerUseCase.invoke(number, answer)
    }
}