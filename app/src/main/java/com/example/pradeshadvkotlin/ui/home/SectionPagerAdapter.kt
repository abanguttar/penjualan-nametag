package com.example.pradeshadvkotlin.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pradeshadvkotlin.databinding.FragmentHomeRecommendedBinding
import com.example.pradeshadvkotlin.model.response.home.Data
import com.example.pradeshadvkotlin.ui.home.newtaste.HomeNewTasteFragment
import com.example.pradeshadvkotlin.ui.home.recommended.popular.HomePopularFragment
import com.example.pradeshadvkotlin.ui.home.recommended.HomeRecommendedFragment

class SectionPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    var newTasteList:ArrayList<Data>? = ArrayList()
    var popularList:ArrayList<Data>? = ArrayList()
    var recommendedList:ArrayList<Data>? = ArrayList()

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "New Produk"
            1 -> "Popular Produk"
            2 -> "Recommended For You"
            else -> ""

        }
    }


    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        return when(position) {
            0 -> {
                fragment = HomeNewTasteFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", newTasteList)
                fragment.arguments = bundle
                return fragment
            }
            1 -> {
                fragment = HomePopularFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", popularList)
                fragment.arguments = bundle
                return fragment
            }
            2 -> {
                fragment = HomeRecommendedFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", recommendedList)
                fragment.arguments = bundle
                return fragment
            }
            else -> {
                fragment = HomeNewTasteFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data", newTasteList)
                fragment.arguments = bundle
                return fragment
            }
        }
    }

    fun setData(newTasteListParms : ArrayList<Data>?, popularListParms : ArrayList<Data>?, recomendedListParms : ArrayList<Data>?) {
        newTasteList = newTasteListParms
        popularList = popularListParms
        recommendedList = recomendedListParms

    }
}