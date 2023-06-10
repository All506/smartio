package com.example.smartio.ui.questions

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.smartio.R
import com.example.smartio.databinding.FragmentQuestionsBinding
import com.example.smartio.domain.IntelligenceComputation
import com.example.smartio.domain.Question
import com.example.smartio.domain.QuestionFactory
import com.example.smartio.domain.WeightMatrix
import com.example.smartio.ui.questions.adapter.QuestionsAdapter


class QuestionsFragment : Fragment() {
    private lateinit var adapter: QuestionsAdapter
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!
    var checkList = mutableListOf<CheckBox>()

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

        val questions = QuestionFactory(requireContext()).getQuestions()


        binding.btnResult.setOnClickListener {
            if(QuestionFactory(requireContext()).allQuestionsAnswered(questions)){

                val answers = mutableListOf<Int>()

                for (question in questions){
                    answers.add(question.answer)
                }

                val intelligenceComputation = IntelligenceComputation(answers)

                val userIntelligence = intelligenceComputation.getIntelligence()

                findNavController().navigate(R.id.action_questionsFragment_to_resultsFragment)
            }
        }

        iniciarRecyclerView(
            context,
            questions
        )


        binding.apply {
            for ((i, question) in questions.withIndex()) {

                var checkBox = CheckBox(requireContext())
                checkList.add(checkBox)
//                checkBox.setButtonDrawable(R.drawable.custom_progress)
                checkBox.isChecked = question.isAnswered
                checkBox.isClickable = false

                val layoutParams = LinearLayout.LayoutParams(
                    resources.getDimensionPixelSize(R.dimen.checkbox_width), // Ancho en píxeles o recurso dimen correspondiente
                    resources.getDimensionPixelSize(R.dimen.checkbox_height), // Alto en píxeles o recurso dimen correspondiente
                    1f // Peso en el LinearLayout
                )

                val colorStateList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.checkbox_backgroung
                    )
                )
                checkBox.buttonTintList = colorStateList

                checkBox.layoutParams = layoutParams
                checkBox.scaleX = 1.2f
                checkBox.scaleY = 1.2f

                if (i<18) {
                    containerChecks.addView(checkBox)
                }else{
                    containerChecks2.addView(checkBox)
                }

            }
            checkList[0].buttonTintList =
                ColorStateList.valueOf(getColorForProgress(questions[0].answer))

        }

    }

    private fun iniciarRecyclerView(context: Context?, questions: List<Question>) {
        binding.apply {
            questions[0].isAnswered = true

            adapter = QuestionsAdapter(questions, checkList)
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerQuestions.layoutManager = layoutManager
            recyclerQuestions.adapter = adapter
            recyclerQuestions.setHasFixedSize(true)

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(recyclerQuestions)

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

                        checkList[pos!!].isChecked = true
                        questions[pos!!].isAnswered = true
                        checkList[pos].buttonTintList =
                            ColorStateList.valueOf(getColorForProgress(questions[pos!!].answer))

                        if(QuestionFactory(requireContext()).allQuestionsAnswered(questions)){
                            btnResult.visibility = View.VISIBLE
                            containerChecks.visibility = View.GONE
                            containerChecks2.visibility = View.GONE
                        }
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

    private fun getColorForProgress(progress: Int): Int {
        val color = when (progress) {
            10 -> Color.parseColor("#B1EDC6")
            9 -> Color.parseColor("#D1F4BD")
            8 -> Color.parseColor("#EAFBC3")
            7 -> Color.parseColor("#FFF7AF")
            6 -> Color.parseColor("#FFE7A7")
            5 -> Color.parseColor("#FFDAA1")
            4 -> Color.parseColor("#FFC495")
            3 -> Color.parseColor("#FFB18A")
            2 -> Color.parseColor("#FF9B80")
            1 -> Color.parseColor("#FF8775")
            else -> Color.parseColor("#FF726A")
        }
        return color
    }
}
