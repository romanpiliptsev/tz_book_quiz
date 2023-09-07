package com.example.tz_book_quiz.di

import androidx.lifecycle.ViewModel
import com.example.tz_book_quiz.presentation.viewmodels.GameViewModel
import com.example.tz_book_quiz.presentation.viewmodels.ResultViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GameViewModel::class)
    fun bindGameViewModel(viewModel: GameViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ResultViewModel::class)
    fun bindResultViewModel(viewModel: ResultViewModel): ViewModel
}