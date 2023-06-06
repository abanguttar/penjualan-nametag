package com.example.pradeshadvkotlin.ui.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pradeshadvkotlin.databinding.FragmentHomeRecommendedBinding
import com.example.pradeshadvkotlin.ui.home.newtaste.HomeNewTasteFragment
import com.example.pradeshadvkotlin.ui.home.recommended.popular.HomePopularFragment
import com.example.pradeshadvkotlin.ui.home.recommended.HomeRecommendedFragment
import com.example.pradeshadvkotlin.ui.profile.account.ProfileAccountFragment
import com.example.pradeshadvkotlin.ui.profile.foodmarket.ProfileFoodmarketFragment

class SectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Account"
            1 -> "PradeshAdv"
            else -> ""

        }
    }


    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        return when(position) {
            0 -> {
                fragment = ProfileAccountFragment()

                return fragment
            }
            1 -> {
                fragment = ProfileFoodmarketFragment()

                return fragment
            }

            else -> {
                fragment = HomeNewTasteFragment()

                return fragment
            }
        }
    }


}