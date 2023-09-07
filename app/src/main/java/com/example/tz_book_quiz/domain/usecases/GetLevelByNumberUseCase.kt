package com.example.tz_book_quiz.domain.usecases

import com.example.tz_book_quiz.domain.Repository
import javax.inject.Inject

class GetLevelByNumberUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(number: Int) = repository.getLevelByNumber(number)
}