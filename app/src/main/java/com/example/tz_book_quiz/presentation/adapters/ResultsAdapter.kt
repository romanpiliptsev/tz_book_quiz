package com.example.tz_book_quiz.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tz_book_quiz.R
import com.example.tz_book_quiz.data.model.Level
import com.example.tz_book_quiz.databinding.QuestionInfoBinding

class ResultsAdapter :
    ListAdapter<Level, ResultsAdapter.ResultsViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val view = QuestionInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ResultsViewHolder(private val binding: QuestionInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(levelItem: Level) = with(binding) {
            number.text = levelItem.number.toString()
            book1.setImageResource(levelItem.imageList[0])
            book2.setImageResource(levelItem.imageList[1])
            book3.setImageResource(levelItem.imageList[2])

            when (levelItem.correctAnswer) {
                1 -> book1
                2 -> book2
                3 -> book3
                else -> throw RuntimeException()
            }.let {
                it.setBackgroundColor(ContextCompat.getColor(it.context, R.color.green))
            }

            if (levelItem.correctAnswer == levelItem.playerAnswer) {
                number.setTextColor(ContextCompat.getColor(number.context, R.color.green))
            } else {
                number.setTextColor(ContextCompat.getColor(number.context, R.color.red))

                when (levelItem.playerAnswer) {
                    1 -> book1
                    2 -> book2
                    3 -> book3
                    else -> throw RuntimeException()
                }.let {
                    it.setBackgroundColor(ContextCompat.getColor(it.context, R.color.red))
                }
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Level>() {
        override fun areItemsTheSame(oldItem: Level, newItem: Level): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Level, newItem: Level): Boolean {
            return oldItem == newItem
        }
    }
}