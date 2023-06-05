package com.example.smartio.ui.questions

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.smartio.R
import com.example.smartio.databinding.FragmentQuestionsBinding
import com.example.smartio.ui.questions.adapter.HorizontalMarginItemDecoration
import com.example.smartio.ui.questions.adapter.QuestionsAdapter

class QuestionsFragment : Fragment() {
    private lateinit var adapter: QuestionsAdapter
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentQuestionsBinding.bind(view)

        iniciarRecyclerView(context, listOf("Pregunta 1", "Pregunta 2", "Pregunta 3", "Pregunta 4", "Pregunta 5", "Pregunta 6", "Pregunta 7", "Pregunta 8", "Pregunta 9", "Pregunta 10"))

        binding.apply {




        }
    }

    private fun iniciarRecyclerView(context: Context?, questions: List<String>) {
        adapter = QuestionsAdapter(questions)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerQuestions.layoutManager = layoutManager
        binding.recyclerQuestions.adapter = adapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerQuestions)

        val marginDecoration = HorizontalMarginItemDecoration(
            resources.getDimensionPixelSize(R.dimen.horizontal_margin),
            resources.getInteger(R.integer.alpha).toInt()
        )
        binding.recyclerQuestions.addItemDecoration(marginDecoration)

    }
}