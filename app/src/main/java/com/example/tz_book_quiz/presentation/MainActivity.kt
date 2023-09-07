package com.example.tz_book_quiz.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
        launchFragment(GameFragment.newInstance())
    }

    fun launchResultFragment() {
        launchFragment(ResultFragment.newInstance())
    }

    fun launchMenuFragment() {
        launchFragment(MenuFragment.newInstance())
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainer.id,
                fragment
            )
            .addToBackStack(null)
            .commit()
    }
}