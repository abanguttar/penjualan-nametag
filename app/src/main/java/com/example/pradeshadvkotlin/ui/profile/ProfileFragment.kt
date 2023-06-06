package com.example.pradeshadvkotlin.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pradeshadvkotlin.PradeshAdv
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.model.response.login.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = inflater.inflate(R.layout.fragment_profile,container,false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sectionPagerAdapter = SectionPagerAdapter(
            childFragmentManager
        )
        viewPager.adapter = sectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        var user = PradeshAdv.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)

        tvName.setText(userResponse.name)
        tvEmail.setText(userResponse.email)

        if (!userResponse.profile_photo_url.isNullOrEmpty()){
            Glide.with(requireActivity())
                .load(userResponse.profile_photo_url)
                .apply(RequestOptions.circleCropTransform())
                .into(ivPicture)
        }

    }


}