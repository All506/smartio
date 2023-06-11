package com.example.smartio.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.smartio.R
import com.example.smartio.data.ApiService
import com.example.smartio.data.Connection.Companion.getRetrofit
import com.example.smartio.databinding.FragmentResultsBinding
import com.example.smartio.domain.IntelligenceComputation
import com.example.smartio.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultsBinding.bind(view)

        CoroutineScope(Dispatchers.IO).launch {
            try {


                var response = User.actualUser.let {
                    it?.let { it1 ->
                        getRetrofit().create(ApiService::class.java).createScores(
                            it1.id, it1.scores!!
                        )
                    }
                }
                if (response != null) {
                    response.body()?.let {
                        binding.apply {
                            requireActivity().runOnUiThread {
                                lblPersonas.text = it[0] + "\n" + it[1] + "\n" + it[2]
                            }

                        }
                    }
                }
            } catch (e: Exception) {
                Log.i("Error", e.message.toString())
            }

        }

        binding.apply {
            lblIntelligence.text =
                IntelligenceComputation.instance?.getIntelligence() ?: ""
            lblDescription.text =
                IntelligenceComputation.instance?.getIntelligenceDescription() ?: ""

        }

    }
}