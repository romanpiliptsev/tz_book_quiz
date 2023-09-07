package com.example.tz_book_quiz.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tz_book_quiz.databinding.ActivityMainBinding
import com.example.tz_book_quiz.presentation.fragments.GameFragment
import com.example.tz_book_quiz.presentation.fragments.MenuFragment
import com.example.tz_book_quiz.presentation.fragments.ResultFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun launchGameFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainer.id,
                GameFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    fun launchResultFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainer.id,
                ResultFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }

    fun launchMenuFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainer.id,
                MenuFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }
}