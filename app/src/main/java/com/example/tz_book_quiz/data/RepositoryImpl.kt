package com.example.tz_book_quiz.data

import com.example.tz_book_quiz.data.model.Level
import com.example.tz_book_quiz.domain.Repository
import com.example.tz_book_quiz.R

object RepositoryImpl : Repository {

    private val levelList: List<Level> = arrayListOf(
        Level(1, "Eh bien, mon prince. Gênes et Lucques ne sont plus que des apanages, des поместья, de la famille Buonaparte.", 1, arrayListOf(R.drawable.war_and_peace, R.drawable.peace, R.drawable.thoughts_on_peace)),
        Level(2, "At about nine in the morning at the end of November in melting snow, the Warsaw train was steaming fast towards St Petersburg", 2, arrayListOf(R.drawable.the_double_and_the_gambler, R.drawable.idiot, R.drawable.the_grand_inquisitor)),
        Level(3, "Two households, both alike in dignity,\nIn fair Verona, where we lay our scene,\nFrom ancient grudge break to new mutiny", 3, arrayListOf(R.drawable.king_lear, R.drawable.swallow, R.drawable.romeo_and_juliet)),
        Level(4, "J was baptized and educated in the Orthodox Christian faith. Even as a child and throughout my adolescence and youth I was schooled in the Orthodox beliefs.", 1, arrayListOf(R.drawable.confession, R.drawable.the_last_skin, R.drawable.hamlet)),
        Level(5, "BARNARDO: Who’s there?\nFRANCISCO: Nay, answer me. Stand and unfold yourself.\nBARNARDO: Long live the King!", 2, arrayListOf(R.drawable.for_whom_the_bell_tolls, R.drawable.hamlet, R.drawable.king_lear)),
        Level(6, "I would never have gone to Greece had it not been for a girl named Betty Ryan who lived in the same house with me in Paris.", 3, arrayListOf(R.drawable.the_pale_king, R.drawable.farewell_to_arms, R.drawable.colossus_of_maroussi)),
        Level(7, "\"Quite impossible, as you see, to start without an introduction,\" laughed Ivan.", 1, arrayListOf(R.drawable.the_grand_inquisitor, R.drawable.idiot, R.drawable.the_sun_also_rises)),
        Level(8, "He was an old man who fished alone in a skiff in the Gulf Stream and he had gone eighty-four days now without taking a fish.", 2, arrayListOf(R.drawable.the_sun_also_rises, R.drawable.the_old_man_and_the_sea, R.drawable.moral_disorder)),
        Level(9, "Robert Cohn was once middleweight boxing champion of Princeton.", 3, arrayListOf(R.drawable.farewell_to_arms, R.drawable.thoughts_on_peace, R.drawable.the_sun_also_rises)),
        Level(10, "At eight o'clock on the evening of the twentieth of May all the six batteries of the N Reserve Artillery Brigade halted for the night in the village of Myestetchki on their way to camp.", 1, arrayListOf(R.drawable.the_kiss, R.drawable.essential_tales, R.drawable.swallow))
    )

    override fun getLevelByNumber(number: Int): Level = levelList[number]

    override fun savePlayerAnswer(number: Int, answer: Int) {
        levelList[number].playerAnswer = answer
    }

    override fun getLevelList(): List<Level> = levelList

    override fun getCountOfCorrectAnswers(): Int =
        levelList.count { it.correctAnswer == it.playerAnswer }
}