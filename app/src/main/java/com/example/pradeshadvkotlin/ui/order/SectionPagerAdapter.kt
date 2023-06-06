package com.example.pradeshadvkotlin.ui.order


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pradeshadvkotlin.databinding.FragmentHomeRecommendedBinding
import com.example.pradeshadvkotlin.model.response.transaction.Data
import com.example.pradeshadvkotlin.ui.home.newtaste.HomeNewTasteFragment
import com.example.pradeshadvkotlin.ui.home.recommended.popular.HomePopularFragment
import com.example.pradeshadvkotlin.ui.home.recommended.HomeRecommendedFragment
import com.example.pradeshadvkotlin.ui.order.inprogress.InprogressFragment
import com.example.pradeshadvkotlin.ui.order.pastorders.PastordersFragment
import com.example.pradeshadvkotlin.ui.profile.account.ProfileAccountFragment
import com.example.pradeshadvkotlin.ui.profile.foodmarket.ProfileFoodmarketFragment

class SectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {


    var inprogressList:ArrayList<Data>? = ArrayList()
    var pastordersList:ArrayList<Data>? = ArrayList()


    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "On Progress"
            1 -> "History"
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
                fragment = InprogressFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", inprogressList)
                fragment.arguments = bundle
                return fragment
            }
            1 -> {
                fragment = PastordersFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", pastordersList)
                fragment.arguments = bundle
                return fragment
            }

            else -> {
                fragment = InprogressFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", inprogressList)
                fragment.arguments = bundle
                return fragment
            }
        }
    }

    fun setData(inprogressListParms:ArrayList<Data>?, pastordersListParms:ArrayList<Data>?){
        inprogressList = inprogressListParms
        pastordersList = pastordersListParms
    }


}