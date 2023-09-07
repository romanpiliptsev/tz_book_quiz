package com.example.tz_book_quiz.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tz_book_quiz.BookQuizApp
import com.example.tz_book_quiz.R
import com.example.tz_book_quiz.data.model.Level
import com.example.tz_book_quiz.databinding.FragmentGameBinding
import com.example.tz_book_quiz.presentation.MainActivity
import com.example.tz_book_quiz.presentation.viewmodels.GameViewModel
import com.example.tz_book_quiz.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

class GameFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by lazy {
        FragmentGameBinding.inflate(layoutInflater)
    }

    private var levelNumber: Int = 0

    private val viewModel: GameViewModel by viewModels {
        viewModelFactory
    }

    private val component by lazy {
        (activity?.application as BookQuizApp).component
    }

    private lateinit var currentLevel: Level

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLevelByNumber(levelNumber)

        viewModel.getLevelLiveData.observe(viewLifecycleOwner) {
            currentLevel = it
            with(binding) {
                book1.setImageResource(it.imageList[0])
                book2.setImageResource(it.imageList[1])
                book3.setImageResource(it.imageList[2])
                textFromBook.text = resources.getString(it.stringId)
            }
        }

        binding.apply {
            val list = arrayListOf(book1, book2, book3)
            list.indices.forEach {
                list[it].setOnClickListener { _ ->
                    viewModel.savePlayerAnswer(levelNumber, it + 1)
                    val toastText: String =
                        if (currentLevel.correctAnswer == it + 1)
                            resources.getString(R.string.correct)
                        else
                            resources.getString(R.string.wrong)

                    Toast.makeText(activity, toastText, Toast.LENGTH_SHORT).show()

                    levelNumber++
                    if (levelNumber == 10) {
                        (requireActivity() as MainActivity).launchResultFragment()
                    } else {
                        viewModel.getLevelByNumber(levelNumber)
                    }
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = GameFragment()
    }
}