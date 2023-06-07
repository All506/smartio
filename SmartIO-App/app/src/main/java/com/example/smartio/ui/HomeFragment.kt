package com.example.smartio.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smartio.MainActivity
import com.example.smartio.R
import com.example.smartio.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val builder = android.app.AlertDialog.Builder(requireContext())

                builder.setTitle("Confirmación")
                    .setMessage("¿Deseas cerrar la sesión actual?")
                    .setPositiveButton("Sí") { _, _ ->
                        // Acciones a realizar si el usuario confirma
                        val intent = Intent(activity, MainActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                    .setNegativeButton("No") { dialog, _ ->
                        // Acciones a realizar si el usuario cancela
                        dialog.cancel()
                    }
                builder.create().show()

            }
        })

        binding.apply {

            btnStartQuestions.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_questionsFragment)
            }


        }
    }
}