package com.example.pradeshadvkotlin.ui.splashscreen

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.ui.auth.AuthActivity

class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.pradeshsplash)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.00f,1.00f)
        Handler().postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }, 3000)
    }
}