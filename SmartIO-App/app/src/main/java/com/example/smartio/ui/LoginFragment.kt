package com.example.smartio.ui

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smartio.HomeActivity
import com.example.smartio.R
import com.example.smartio.data.ApiService
import com.example.smartio.data.Connection
import com.example.smartio.databinding.FragmentLoginBinding
import com.example.smartio.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.EOFException

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMediaPlayer: MediaPlayer
    private var mCurrentPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        binding.apply {


            val uri =
                Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.smile)

            wBackground.setVideoURI(uri)
            wBackground.start()
            wBackground.setOnPreparedListener { mp ->
                mMediaPlayer = mp
                mMediaPlayer.isLooping = true

                if (mCurrentPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentPosition)
                    mMediaPlayer.start()
                }
            }


            btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }

            btnLogin.setOnClickListener {

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val response = Connection.getRetrofit().create(ApiService::class.java)
                            .loginUser(
                                User(
                                    0,
                                    "",
                                    txtEmail.text.toString(),
                                    txtPassword.text.toString(),
                                    mutableListOf()
                                )
                            )
                        if (response.isSuccessful) {
                            Log.i("LoginFragment", response.body().toString())
                            response.body()?.let {
                                requireActivity().runOnUiThread {
                                    val intent = Intent(activity, HomeActivity::class.java)
                                    startActivity(intent)
                                    activity?.finish()
                                    User.actualUser = it
                                    Toast.makeText(
                                        requireContext(),
                                        "Bienvenido ${it.name}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    } catch (e: EOFException) {
                        requireActivity().runOnUiThread {
                            txtEmail.text.clear()
                            txtPassword.text.clear()
                            AlertDialog.Builder(requireContext())
                                .setTitle("Error")
                                .setMessage("Usuario o contraseña incorrectos")
                                .setPositiveButton("Ok") { _, _ ->
                                }.show()
                        }
                    } catch (e: Exception) {
                        requireActivity().runOnUiThread {
                            Toast.makeText(
                                requireContext(),
                                "Error de conexión",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }


                }


            }

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        mMediaPlayer.release()
    }


}