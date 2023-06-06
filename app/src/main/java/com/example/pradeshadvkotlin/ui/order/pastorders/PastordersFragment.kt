package com.example.pradeshadvkotlin.ui.order.pastorders

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.model.response.transaction.Data
import com.example.pradeshadvkotlin.ui.order.detailsorders.OrdersDetailActivity
import kotlinx.android.synthetic.main.fragment_pastorders.*

class PastordersFragment : Fragment(),PastordersAdapter.ItemAdapterCallback {

    private var adapter: PastordersAdapter?=null
    var pastordersList:ArrayList<Data>? = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pastorders, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        pastordersList = arguments?.getParcelableArrayList("data")

        if (!pastordersList.isNullOrEmpty()) {
            adapter= PastordersAdapter(pastordersList!!, this)
            val layoutManager = LinearLayoutManager(activity)
            rcList.layoutManager = layoutManager
            rcList.adapter = adapter
        }
    }

    override fun onClick(v: View, data: Data) {
//      val detail = Intent(activity, OrdersDetailActivity::class.java).putExtra("data", data)
//      startActivity(detail)
        Toast.makeText(activity,"Ini Transaksi Kamu yang sudah selesai", Toast.LENGTH_LONG).show()
    }


}