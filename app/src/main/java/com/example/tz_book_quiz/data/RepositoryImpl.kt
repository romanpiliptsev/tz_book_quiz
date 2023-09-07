package com.example.tz_book_quiz.data

import com.example.tz_book_quiz.R
import com.example.tz_book_quiz.data.model.Level
import com.example.tz_book_quiz.domain.Repository

object RepositoryImpl : Repository {

    private val levelList: List<Level> = arrayListOf(
        Level(
            1,
            R.string.level_1_text,
            1,
            arrayListOf(R.drawable.war_and_peace, R.drawable.peace, R.drawable.thoughts_on_peace)
        ),
        Level(
            2,
            R.string.level_2_text,
            2,
            arrayListOf(
                R.drawable.the_double_and_the_gambler,
                R.drawable.idiot,
                R.drawable.the_grand_inquisitor
            )
        ),
        Level(
            3,
            R.string.level_3_text,
            3,
            arrayListOf(R.drawable.king_lear, R.drawable.swallow, R.drawable.romeo_and_juliet)
        ),
        Level(
            4,
            R.string.level_4_text,
            1,
            arrayListOf(R.drawable.confession, R.drawable.the_last_skin, R.drawable.hamlet)
        ),
        Level(
            5,
            R.string.level_5_text,
            2,
            arrayListOf(R.drawable.for_whom_the_bell_tolls, R.drawable.hamlet, R.drawable.king_lear)
        ),
        Level(
            6,
            R.string.level_6_text,
            3,
            arrayListOf(
                R.drawable.the_pale_king,
                R.drawable.farewell_to_arms,
                R.drawable.colossus_of_maroussi
            )
        ),
        Level(
            7,
            R.string.level_7_text,
            1,
            arrayListOf(
                R.drawable.the_grand_inquisitor,
                R.drawable.idiot,
                R.drawable.the_sun_also_rises
            )
        ),
        Level(
            8,
            R.string.level_8_text,
            2,
            arrayListOf(
                R.drawable.the_sun_also_rises,
                R.drawable.the_old_man_and_the_sea,
                R.drawable.moral_disorder
            )
        ),
        Level(
            9,
            R.string.level_9_text,
            3,
            arrayListOf(
                R.drawable.farewell_to_arms,
                R.drawable.thoughts_on_peace,
                R.drawable.the_sun_also_rises
            )
        ),
        Level(
            10,
            R.string.level_10_text,
            1,
            arrayListOf(R.drawable.the_kiss, R.drawable.essential_tales, R.drawable.swallow)
        )
    )

    override fun getLevelByNumber(number: Int): Level = levelList[number]

    override fun savePlayerAnswer(number: Int, answer: Int) {
        levelList[number].playerAnswer = answer
    }

    override fun getLevelList(): List<Level> = levelList

    override fun getCountOfCorrectAnswers(): Int =
        levelList.count { it.correctAnswer == it.playerAnswer }
}