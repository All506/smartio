package com.example.smartio.ui.questions

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.smartio.R
import com.example.smartio.databinding.FragmentQuestionsBinding
import com.example.smartio.ui.questions.adapter.Questions
import com.example.smartio.ui.questions.adapter.QuestionsAdapter


class QuestionsFragment : Fragment() {
    private lateinit var adapter: QuestionsAdapter
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!
    private val progressBar: ProgressBar? = null

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

        val questions = Questions(requireContext()).getQuestions()

        iniciarRecyclerView(
            context,
            questions
        )

        binding.apply {


        }
    }

    private fun iniciarRecyclerView(context: Context?, questions: List<String>) {
        binding.apply {
            adapter = QuestionsAdapter(questions)
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerQuestions.layoutManager = layoutManager
            recyclerQuestions.adapter = adapter
            recyclerQuestions.setHasFixedSize(true)

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(recyclerQuestions)

            //recyclerQuestions.setPadding(130, 100, 130, 100)

            Handler().postDelayed({
                val viewHolder: RecyclerView.ViewHolder? =
                    recyclerQuestions.findViewHolderForAdapterPosition(0)
                val rl1: RelativeLayout? =
                    viewHolder?.itemView?.findViewById(R.id.layoutItemQuestions)
                rl1?.animate()?.scaleY(1f)?.scaleX(1f)?.setDuration(350)
                    ?.setInterpolator(AccelerateInterpolator())
                    ?.start()
            }, 100)


            recyclerQuestions.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (recyclerView != null) {
                        super.onScrollStateChanged(recyclerView, newState)
                    }
                    val v: View? = snapHelper.findSnapView(layoutManager)
                    val pos = v?.let { layoutManager.getPosition(it) }
                    val viewHolder: RecyclerView.ViewHolder? =
                        pos?.let { recyclerQuestions.findViewHolderForAdapterPosition(it) }
                    val rl1: RelativeLayout? =
                        viewHolder?.itemView?.findViewById(R.id.layoutItemQuestions)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        rl1?.animate()?.setDuration(350)?.scaleX(1f)?.scaleY(1f)
                            ?.setInterpolator(AccelerateInterpolator())
                            ?.start()
                    } else {
                        rl1?.animate()?.setDuration(350)?.scaleX(0.75f)?.scaleY(0.75f)
                            ?.setInterpolator(AccelerateInterpolator())?.start()
                    }
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (recyclerView != null) {
                        super.onScrolled(recyclerView, dx, dy)
                    }
                }
            })
        }


    }

    fun showProgressBar(show: Boolean) {
        if (show) {
            progressBar!!.visibility = View.VISIBLE
        } else {
            progressBar!!.visibility = View.GONE
        }
    }
}