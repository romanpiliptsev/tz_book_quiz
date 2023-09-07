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

            setBackgroundColor(R.color.green, levelItem.correctAnswer)

            if (levelItem.correctAnswer == levelItem.playerAnswer) {
                number.setTextColor(ContextCompat.getColor(number.context, R.color.green))
            } else {
                number.setTextColor(ContextCompat.getColor(number.context, R.color.red))
                setBackgroundColor(R.color.red, levelItem.playerAnswer)
            }
        }

        private fun setBackgroundColor(colorId: Int, answer: Int) {
            when (answer) {
                1 -> binding.book1
                2 -> binding.book2
                3 -> binding.book3
                else -> throw RuntimeException()
            }.let {
                it.setBackgroundColor(ContextCompat.getColor(it.context, colorId))
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