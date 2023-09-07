package com.example.tz_book_quiz.di

import com.example.tz_book_quiz.data.RepositoryImpl
import com.example.tz_book_quiz.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface Module {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {
        @Provides
        @ApplicationScope
        fun provideRepositoryImpl(): RepositoryImpl {
            return RepositoryImpl
        }
    }
}