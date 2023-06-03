package com.example.smartio

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.AsyncPlayer
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    protected lateinit var vv_fondo: VideoView
    protected lateinit var mMediaPlayer: MediaPlayer
    protected var mCurrentPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Will hide support bar
        supportActionBar?.hide()
        //No rotation
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        vv_fondo= findViewById(R.id.w_background)
        val uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.smile)

        vv_fondo.setVideoURI(uri)
        vv_fondo.start()
        vv_fondo.setOnPreparedListener{ mp ->
            mMediaPlayer = mp
            mMediaPlayer.isLooping = true

            if (mCurrentPosition != 0){
                mMediaPlayer.seekTo(mCurrentPosition)
                mMediaPlayer.start()
            }
        }

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()

        mCurrentPosition = mMediaPlayer.currentPosition
        vv_fondo.pause()
    }

    override fun onResume() {
        super.onResume()

        vv_fondo.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        mMediaPlayer.release()
    }
}