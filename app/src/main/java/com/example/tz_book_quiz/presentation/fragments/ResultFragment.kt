package com.example.tz_book_quiz.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tz_book_quiz.BookQuizApp
import com.example.tz_book_quiz.databinding.FragmentResultBinding
import com.example.tz_book_quiz.presentation.MainActivity
import com.example.tz_book_quiz.presentation.adapters.ResultsAdapter
import com.example.tz_book_quiz.presentation.viewmodels.ResultViewModel
import com.example.tz_book_quiz.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

class ResultFragment : Fragment() {

    private val binding by lazy {
        FragmentResultBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val vm: ResultViewModel by viewModels {
        viewModelFactory
    }

    private val component by lazy {
        (activity?.application as BookQuizApp).component
    }

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

        val adapter = ResultsAdapter()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        adapter.submitList(vm.getLevelList())

        binding.result.text = "Your result: ${vm.getCountOfCorrectAnswers()} / 10"

        binding.buttonPlay.setOnClickListener {
            (requireActivity() as MainActivity).launchMenuFragment()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ResultFragment()
    }
}