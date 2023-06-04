package com.example.smartio.ui

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smartio.HomeActivity
import com.example.smartio.R
import com.example.smartio.databinding.FragmentLoginBinding

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

                //TODO Agregar validaciones de login

                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
                
                activity?.finish()
            }

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        mMediaPlayer.release()
    }


}