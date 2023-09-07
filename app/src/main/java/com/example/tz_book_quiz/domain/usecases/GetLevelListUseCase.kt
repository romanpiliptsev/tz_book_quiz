package com.example.tz_book_quiz.domain.usecases

import com.example.tz_book_quiz.domain.Repository
import javax.inject.Inject

class GetLevelListUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke() = repository.getLevelList()
}