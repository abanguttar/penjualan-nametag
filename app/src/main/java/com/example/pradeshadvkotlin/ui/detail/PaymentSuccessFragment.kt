package com.example.pradeshadvkotlin.ui.detail

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.ui.MainActivity
import com.example.pradeshadvkotlin.ui.order.OrderFragment
import kotlinx.android.synthetic.main.fragment_payment_success.*


class PaymentSuccessFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_success, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as DetailActivity).toolbarDetail()
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(activity!!.applicationContext, R.raw.ordersuccess)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.00f,1.00f)

        btnOtherFood.setOnClickListener {
            requireActivity().finish()
        }

        btnMyOrder.setOnClickListener {
            requireActivity().finish()
        }

    }



}