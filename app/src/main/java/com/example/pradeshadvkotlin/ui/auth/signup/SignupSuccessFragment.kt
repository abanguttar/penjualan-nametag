package com.example.pradeshadvkotlin.ui.auth.signup

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_signup_success.*


class SignupSuccessFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_success, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var mediaPlayer: MediaPlayer? = MediaPlayer.create(activity!!.applicationContext, R.raw.register)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.00f,1.00f)

        btnFind.setOnClickListener {
            val home = Intent(activity, MainActivity::class.java)
            activity?.finish()
            startActivity(home)
        }
    }


}