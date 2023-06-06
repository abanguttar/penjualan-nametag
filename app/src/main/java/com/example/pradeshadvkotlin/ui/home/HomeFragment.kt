package com.example.pradeshadvkotlin.ui.home

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.clearFragmentResult
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pradeshadvkotlin.PradeshAdv
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.model.response.home.Data
import com.example.pradeshadvkotlin.model.response.home.HomeResponse
import com.example.pradeshadvkotlin.model.response.login.User
import com.example.pradeshadvkotlin.ui.MainActivity
import com.example.pradeshadvkotlin.ui.detail.DetailActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeAdapter.ItemAdapterCallback , HomeContract.View{
    private var newStateList : ArrayList<Data> = ArrayList()
    private var popularList : ArrayList<Data> = ArrayList()
    private var recomendedList : ArrayList<Data> = ArrayList()
    private lateinit var presenter:HomePresenter
    var progressDialog : Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {


        super.onActivityCreated(savedInstanceState)

        var user = PradeshAdv.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)
        if (!userResponse.profile_photo_url.isNullOrEmpty()) {
            Glide.with(requireActivity())
                .load(userResponse.profile_photo_url)
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfil);
        }
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(activity!!.applicationContext, R.raw.logins)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.00f,1.00f)
        initView()
        presenter = HomePresenter(this)
        presenter.getHome()


      //  initDataDummy()
    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }


    }

  //  fun initDataDummy() {
 //       produkList = ArrayList()
 //       produkList.add(HomeModel("Cherry Healthy","",5f))
 //       produkList.add(HomeModel("Burger Tamayo","",4f))
 //       produkList.add(HomeModel("Bakhwan Cihuy","",4.5f))
 //  }

    override fun onClick(v: View, data: Data) {
        var bundle = Bundle()
        bundle.putParcelable("data", data)
        val detail = Intent(activity, DetailActivity::class.java).putExtras(bundle)
        startActivity(detail)
    }

    override fun onHomeSuccess(homeResponse: HomeResponse) {

        for (a in homeResponse.data.indices) {

            var items:List<String> = homeResponse.data[a].types?.split(",") ?: ArrayList()
            for (x in items.indices) {
                if (items[x].equals("new_produk", true)) {
                    newStateList?.add(homeResponse.data[a])
                } else if (items[x].equals("recommended", true)) {
                    recomendedList?.add(homeResponse.data[a])
                } else if (items[x].equals("popular", true)) {
                    popularList?.add(homeResponse.data[a])
                }
            }
        }





        var adapter = HomeAdapter(homeResponse.data,this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

        val sectionPagerAdapter = SectionPagerAdapter(
            childFragmentManager
        )
        sectionPagerAdapter.setData(newStateList, popularList, recomendedList)
        viewPager.adapter = sectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onHomeFailed(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
       progressDialog?.show()
    }

    override fun dismissLoading() {
       progressDialog?.dismiss()
    }
}