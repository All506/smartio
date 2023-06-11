package com.example.smartio.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.smartio.R
import com.example.smartio.data.ApiService
import com.example.smartio.data.Connection
import com.example.smartio.databinding.FragmentSignUpBinding
import com.example.smartio.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSignUpBinding.bind(view)

        binding.apply {
            btnSignup.setOnClickListener {

                val user = User(
                    0,
                    name = etxName.text.toString(),
                    email = etxEmailAddress.text.toString(),
                    password = etxPassword.text.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val response =
                            Connection.getRetrofit().create(ApiService::class.java).createUser(user)
                        if (response.isSuccessful) {
                            requireActivity().runOnUiThread {
                                AlertDialog.Builder(requireContext())
                                    .setTitle("Success")
                                    .setMessage("User created successfully, please login")
                                    .setPositiveButton("Ok") { _, _ ->
                                        requireActivity().onBackPressed()
                                    }.show()
                            }
                        } else {
                            requireActivity().runOnUiThread {
                                Toast.makeText(
                                    requireContext(),
                                    "Error de conexión",
                                    Toast.LENGTH_SHORT
                                ).show()
                                Log.i("Error", response.errorBody().toString())
                            }
                        }
                    } catch (e: Exception) {
                        requireActivity().runOnUiThread {
                            Toast.makeText(
                                requireContext(),
                                "Error de conexión",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.i("Error", e.message.toString())
                        }
                    }
                }
            }
        }
    }


}
